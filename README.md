# 数勋科技 Java SDK

[![CI](https://github.com/EerieDaemon/shuxuntech-java-sdk/actions/workflows/ci.yml/badge.svg)](https://github.com/EerieDaemon/shuxuntech-java-sdk/actions/workflows/ci.yml)
[![JitPack](https://jitpack.io/v/EerieDaemon/shuxuntech-java-sdk.svg)](https://jitpack.io/#EerieDaemon/shuxuntech-java-sdk)
[![License](https://img.shields.io/badge/license-Apache--2.0-blue.svg)](LICENSE)

数勋科技开放平台（shuxuntech）的 Java SDK，封装了平台要求的签名鉴权、表单提交、统一响应解析与异常处理，
让业务代码只关心参数和结果。

- 自动生成 `appKey` / `timestamp` / `sign` 请求头，按 `sha256(appKey + timestamp + appSecret)` 规则签名
- 参数按 `application/x-www-form-urlencoded` 提交，统一解析 `code` / `msg` / `data` / `seqNo`
- 支持 `JsonNode` 通用返回和 POJO 强类型映射（含泛型）
- 内置 37 个接口响应模型（`com.shuxuntech.sdk.model.result`），字段与平台契约保持一致
- 连接超时、读取超时可配置；支持注入自定义传输层（代理、链路追踪、测试替身）
- 线程安全，全局复用一个实例即可；不自动重试，避免重复计费
- Java 8 字节码，兼容 JDK 8 / 11 / 17 / 21

## 环境要求

| 项目 | 要求 |
| --- | --- |
| JDK | 8 及以上（编译目标为 Java 8） |
| Maven | 3.6+ |

运行时依赖只有 [OkHttp](https://square.github.io/okhttp/) 与 [Jackson](https://github.com/FasterXML/jackson-databind)，
不会传递日志框架。

## 安装

当前版本通过 [JitPack](https://jitpack.io/#EerieDaemon/shuxuntech-java-sdk) 分发，在 `pom.xml` 中加入仓库和依赖：

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.EerieDaemon</groupId>
        <artifactId>shuxuntech-java-sdk</artifactId>
        <version>v0.2.0</version>
    </dependency>
</dependencies>
```

Gradle：

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.EerieDaemon:shuxuntech-java-sdk:v0.2.0'
}
```

> JitPack 首次拉取时会现场构建，通常需要 1~3 分钟；若失败可在
> [构建页面](https://jitpack.io/#EerieDaemon/shuxuntech-java-sdk) 查看日志后重试。

## 快速开始

```java
import com.fasterxml.jackson.databind.JsonNode;
import com.shuxuntech.sdk.ShuxunClient;
import com.shuxuntech.sdk.model.ApiResponse;
import com.shuxuntech.sdk.model.Params;

public class Demo {

    public static void main(String[] args) {
        try (ShuxunClient client = ShuxunClient.builder()
                .appKey(System.getenv("SHUXUN_APP_KEY"))
                .appSecret(System.getenv("SHUXUN_APP_SECRET"))
                .build()) {

            ApiResponse<JsonNode> response = client.post(
                    "/v1/idCard/check",                     // 身份证实名核验
                    Params.create()
                            .put("name", "张三")
                            .put("idCard", "110101199001011234"));

            if (response.isSuccess()) {
                System.out.println(response.getData());
            } else {
                System.err.printf("调用失败 code=%d(%s), msg=%s, seqNo=%s%n",
                        response.getCode(), response.getMsg(), response.getSeqNo());
            }
        }
    }
}
```

`appKey` 与 `appSecret` 请从环境变量、配置中心或密钥管理系统读取，不要硬编码进仓库。

## 强类型返回

SDK 内置了各接口的响应模型（`com.shuxuntech.sdk.model.result`），字段与平台契约
（sx-data 的 `com.shuxun.data.api.result`）一一对应，直接 `import` 即可：

```java
import com.shuxuntech.sdk.model.result.IdCardCheckResult;

ApiResponse<IdCardCheckResult> response = client.post(
        "/v1/idCard/check",
        Params.create().put("name", "张三").put("idCard", "110101199001011234"),
        IdCardCheckResult.class);

if (response.isSuccess() && Integer.valueOf(1).equals(response.getData().getResult())) {
    // 核验一致
}
```

已覆盖的模型（37 个）：

| 分类 | 模型 |
| --- | --- |
| 身份核验 | `IdCardCheckResult`、`IdCardCommonResult`、`FaceIdCardResult`、`FaceCompareResult`、`LivingCheckResult`、`LivingSdkResult` |
| 运营商 | `Mobile23Result`、`MobileEmptyResult`、`MobileEmptyResultV2`、`MobileOnlineResult`、`MobileStatusResult`、`MobileTransformResult` |
| 银行卡 | `Bankcard234Result`、`BankcardOcrResult`、`BankPlaceResult`、`EntAcctCheckResult` |
| OCR | `IdCardOcrResult`、`WordOcrResult`、`BusinessOcrResult`、`DrivingOcrResult`、`PlateOcrResult`、`VehicleOcrResult`、`VinOcrResult` |
| 企业 | `Enterprise2Result`、`Enterprise3Result`、`Enterprise4Result`、`EnterpriseBaseInfoResult`、`EnterpriseContactsInfoResult`、`EnterpriseLikeResult`、`EnterpriseNameLikeResult`、`EnterpriseReportResult` |
| 交通 | `Vin2Result`、`Vin2_1Result`、`Vin5Result`、`CarFiveResult` |
| 其他 | `IpQueryCityResult`、`SmsSendResult` |

未覆盖的接口可以自行定义 POJO，或直接使用 `JsonNode`：

```java
ApiResponse<JsonNode> response = client.post("/v1/xxx", params);
```

泛型返回（例如 `List<Item>`）使用 Jackson 的 `TypeReference`：

```java
ApiResponse<List<Item>> response = client.post(
        "/your/api/path", params, new TypeReference<List<Item>>() {});
```

SDK 默认忽略响应中的未知字段，平台新增字段不会导致反序列化失败。

## 异常处理

平台在 HTTP 400/500 时同样会返回统一 JSON，SDK 不会因为状态码非 2xx 丢弃响应体：

| 场景 | 行为 |
| --- | --- |
| 网络不可达、连接超时 | 抛出 `ShuxunTransportException`，`getHttpStatus()` 为 0 |
| HTTP 非 2xx，但响应体是平台统一结构（含 `code`） | 正常返回 `ApiResponse`，`getHttpStatus()` 保存真实状态码，用 `code` 判断结果 |
| HTTP 非 2xx 且响应体不是平台结构（如网关的 HTML 错误页） | 抛出 `ShuxunTransportException`，可用 `getHttpStatus()`、`getResponseBody()` 取状态码和原始响应 |
| HTTP 2xx 但响应不是合法 JSON | 抛出 `ShuxunTransportException`，`getResponseBody()` 为原始响应 |
| 业务返回 `code != 0`，调用 `post` | 正常返回 `ApiResponse`，由调用方判断 `isSuccess()` |
| 业务返回 `code != 0`，调用 `postOrThrow` | 抛出 `ShuxunApiException`，包含 `code`、`msg`、`seqNo` |

```java
ApiResponse<IdCardCheckResult> response = client.post(
        "/v1/idCard/check", params, IdCardCheckResult.class);

if (!response.isSuccess()) {
    // HTTP 400/500 也可能走到这里，code、msg、seqNo 依然可用
    System.err.printf("HTTP %s, code=%d(%s), msg=%s, seqNo=%s%n",
            response.getHttpStatus(),
            response.getCode(),
            ResponseCodes.describe(response.getCode()),
            response.getMsg(),
            response.getSeqNo());
}
```

需要异常时改用 `postOrThrow`：

```java
try {
    ApiResponse<IdCardCheckResult> response =
            client.postOrThrow("/v1/idCard/check", params, IdCardCheckResult.class);
} catch (ShuxunApiException e) {
    // 业务错误：参数、签名、余额、频率等
    System.err.println(e.getCode() + " " + e.getMsg() + " " + e.getSeqNo());
} catch (ShuxunTransportException e) {
    // 网络或网关层错误，可按需重试
    System.err.println(e.getHttpStatus() + " " + e.getMessage());
    System.err.println(e.getResponseBody());
}
```

## 配置项

| 构建器方法 | 默认值 | 说明 |
| --- | --- | --- |
| `baseUrl(String)` | `https://api.shuxuntech.com` | 网关地址，以控制台或接口文档为准 |
| `appKey(String)` | 必填 | 控制台创建应用后分配 |
| `appSecret(String)` | 必填 | 请勿提交到代码仓库 |
| `connectTimeout(Duration)` | 5 秒 | 建连超时 |
| `readTimeout(Duration)` | 15 秒 | 读取超时 |
| `writeTimeout(Duration)` | 15 秒 | 写入超时 |
| `transport(HttpTransport)` | OkHttp | 自定义传输层，注入后由调用方负责关闭 |

```java
ShuxunClient client = ShuxunClient.builder()
        .baseUrl("https://api.shuxuntech.com")
        .appKey("your-app-key")
        .appSecret("your-app-secret")
        .connectTimeout(Duration.ofSeconds(3))
        .readTimeout(Duration.ofSeconds(10))
        .build();
```

## 签名与鉴权

平台要求每个请求在请求头中携带三个字段：

| Header | 说明 |
| --- | --- |
| `appKey` | 应用标识 |
| `timestamp` | 当前毫秒时间戳 |
| `sign` | `sha256(appKey + timestamp + appSecret)`，小写十六进制 |

`timestamp` 与服务端时间偏差超过 5 分钟会返回 `code = 4`（签名错误），部署前请确保服务器时间同步
（例如启用 NTP）。SDK 会在每次请求时自动生成新的时间戳与签名。

需要自行排障时，可以直接调用签名工具：

```java
String sign = com.shuxuntech.sdk.auth.Signature.sign("appKey", "appSecret", System.currentTimeMillis());
```

## 返回码

| code | 含义 | 排查建议 |
| --- | --- | --- |
| 0 | 成功 | — |
| 1 | 参数错误 | 检查必填参数、格式 |
| 2 | 无记录 | 权威库未查到，属正常业务返回 |
| 3 | 第三方服务异常 | 上游通道波动，可重试或联系技术支持 |
| 4 | 签名错误 | 核对 appSecret、时间戳偏差 |
| 5 | 余额不足 | 充值或购买套餐 |
| 6 | 调用频率超限 | 降低并发或申请提升 QPS |
| 7 | 账号停用 | 联系客服 |
| 8 | 接口已停用 | 改用替代接口 |
| 9 | 未开通接口权限 | 控制台申请开通 |
| 10 | IP 不在白名单 | 控制台加入调用方 IP |
| 11 | 系统异常 | 携带 `seqNo` 联系技术支持 |
| 12 | 实名状态错误 | 先完成企业实名认证 |
| 99 | 其他异常 | 以 `msg` 为准 |

完整说明见 [官方错误码文档](https://shuxuntech.com/help#errorcode)。

## 线程安全与重试

- `ShuxunClient` 内部复用一个 `OkHttpClient`，可在多个线程间共享，建议作为单例使用，应用关闭时调用 `close()`。
- SDK **不会自动重试**：平台接口通常按次计费，是否重试以及重试次数应由业务根据接口特性决定。
- 当前版本不内置日志输出，需要记录请求耗时或排障时，可通过自定义 `HttpTransport` 包装实现。

## 项目结构

```
shuxuntech-java-sdk
├── pom.xml
├── src/main/java/com/shuxuntech/sdk
│   ├── ShuxunClient.java            # 入口：构建器、签名、请求、响应解析
│   ├── auth/Signature.java          # SHA-256 签名工具
│   ├── http/                        # 传输层抽象与 OkHttp 实现
│   ├── model/                       # Params、ApiResponse、返回码
│   ├── model/result/                # 37 个接口响应模型
│   ├── exception/                   # 业务异常与传输异常
│   └── internal/Json.java           # 共享 ObjectMapper
└── src/test/java                    # 单元测试与 MockWebServer 集成测试
```

## 本地开发

```bash
mvn clean verify            # 编译、运行测试
mvn -Prelease package       # 额外生成 sources / javadoc jar
```

发布新版本（JitPack 按 tag 构建）：

```bash
git tag v0.2.0
git push origin v0.2.0
```

## 后续计划

- [ ] 按接口分类提供强类型客户端（OCR、身份核验、银行卡、企业、交通等），隐藏路径与字段细节
- [ ] 补充各接口的请求/响应模型与文档链接
- [ ] 支持文件上传（multipart）类 OCR 接口
- [ ] 发布到 Maven Central，进一步简化为单段 `dependency`

## 许可证

[Apache License 2.0](LICENSE)
