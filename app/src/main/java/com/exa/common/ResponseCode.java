package com.exa.common;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ResponseCode implements BaseEnum<Integer> {
    CODE_SUCCESS(0, "成功", "SUCCESS"),
    CODE_BUSINESS_ERROR(1, "业务错误", "未知错误"),
    CODE_NEED_CONFIRM(2, "是否确认", "是否确认"),
    CODE_INNER_API_ERROR(8, "内部API错误", "内部API错误"),
    CODE_USER_API_ERROR(9, "用户系统错误", "用户系统错误"),
    CODE_SQL_ERROR(10, "系统错误", "SQL错误"),
    CODE_PARAMETER_ERROR(20, "参数错误", "参数错误"),
    CODE_UUID_NOT_EXISTS_ERROR(21, "数据不存在", "数据不存在"),
    CODE_TASK_ERROR(30, "任务错误", "任务错误"),
    CODE_MINIO_ERROR(31, "存储错误", "存储错误"),
    CODE_K8S_ERROR(32, "运行环境错误", "运行环境错误"),
    CODE_REPEAT_REQUEST(90, "重复请求", "重复请求"),
    CODE_SYSTEM_ERROR(99, "系统错误", "系统错误"),
    CODE_PATH_NOT_FOUND_ERROR(404, "路径错误", "路径错误"),
    CODE_NETWORK_CONNECT_ERROR(503, "网络错误", "网络错误"),
    CODE_SANDBOX_PROVIDER_RESPONSE_ERROR(900, "服务返回异常", "服务返回异常"),
    CODE_AUTHORITY_ERROR(40, "没有权限", "没有权限"),
    CODE_DATA_AUTHORITY_ERROR(41, "没有数据权限", "没有数据权限"),
    CODE_STATUS_FORBID_OPERATION_ERROR(50, "当前状态禁止操作", "当前状态禁止操作"),
    CODE_MESSAGE_SEND_ERROR(60, "消息发送失败", "消息发送失败"),
    CODE_RESOURCE_NOT_ENOUGH_ERROR(1001, "资源数不够", "资源数不够"),
    CODE_RESOURCE_STAGE_TIME_ERROR(1002, "请填写合理的阶段时间区间", "请填写合理的阶段时间区间"),
    CODE_RESOURCE_USER_EXISTS_SANDBOX_ERROR(1003, "所选用户已有沙箱", "所选用户已有沙箱"),
    CODE_RESOURCE_UWEBTOP_ERROR(1004, "uwebtop获取连接信息错误", "uwebtop获取连接信息错误"),
    CODE_RESOURCE_USER_SANDBOX_NOT_EXISTS(1005, "您还未分配沙箱资源", "您还未分配沙箱资源"),
    CODE_DATA_MANAGE_DATA_SOURCE_INVALID_NAME(2001, "数据源名称无效", "数据源名称无效"),
    CODE_DATA_MANAGE_DATA_SOURCE_INVALID_TYPE(2002, "数据源类型无效", "数据源类型无效"),
    CODE_DATA_MANAGE_DATA_SOURCE_INVALID_IP(2003, "数据源地址无效", "数据源地址无效"),
    CODE_DATA_MANAGE_DATA_SOURCE_INVALID_PORT(2004, "数据源端口无效", "数据源端口无效"),
    CODE_DATA_MANAGE_DATA_SOURCE_INVALID_DATABASE(2005, "数据源数据库无效", "数据源数据库无效"),
    CODE_DATA_MANAGE_DATA_SOURCE_INVALID_USERNAME(2006, "数据源用户名无效", "数据源用户名无效"),
    CODE_DATA_MANAGE_DATA_SOURCE_INVALID_PASSWORD(2007, "数据源密码无效", "数据源密码无效"),
    CODE_DATA_MANAGE_DATA_SOURCE_DUPLICATE_NAME(2008, "数据源名称重复", "数据源名称重复"),
    CODE_DATA_MANAGE_DATA_SOURCE_CONNECTION_FAILED(2010, "数据源连接失败", "数据源连接失败"),
    CODE_DATA_MANAGE_DATA_SOURCE_UNSUPPORTED_TYPE(2011, "数据源类型不支持", "数据源类型不支持"),
    CODE_DATA_MANAGE_DATA_SOURCE_NOT_EXISTS(2012, "数据源不存在", "数据源不存在"),
    CODE_DATA_MANAGE_SAMPLE_DATA_SOURCE_NOT_EXISTS(2101, "样例数据源不存在", "样例数据源不存在"),
    CODE_DATA_MANAGE_SAMPLE_DATA_SOURCE_DUPLICATE(2102, "样例数据源已存在", "样例数据源已存在"),
    CODE_DATA_MANAGE_DATA_TABLE_INVALID_SCHEMA(2301, "数据表基本信息无效", "数据表基本信息无效"),
    CODE_DATA_MANAGE_DATA_TABLE_INVALID_NAME(2302, "数据名称无效", "数据名称无效"),
    CODE_DATA_MANAGE_DATA_TABLE_INVALID_TABLE_NAME(2303, "数据表名无效", "数据表名无效"),
    CODE_DATA_MANAGE_DATA_TABLE_INVALID_CATEGORY(2304, "分类无效", "分类无效"),
    CODE_DATA_MANAGE_DATA_TABLE_INVALID_UPDATE_RATE(2305, "更新频率无效", "更新频率无效"),
    CODE_DATA_MANAGE_DATA_TABLE_INVALID_DESCRIPTION(2306, "描述无效", "描述无效"),
    CODE_DATA_MANAGE_DATA_TABLE_INVALID_THEMEID(2307, "主题id无效", "主题id无效"),
    CODE_DATA_MANAGE_DATA_TABLE_INVALID_INDUSTRYID(2308, "行业id无效", "行业id无效"),
    CODE_DATA_MANAGE_DATA_TABLE_INVALID_SERVICEID(2309, "服务id无效", "服务id无效"),
    CODE_DATA_MANAGE_DATA_TABLE_INVALID_TAGID(2310, "标签无效", "标签无效"),
    CODE_DATA_MANAGE_DATA_TABLE_COLUMN_INVALID_SCHEMA(2311, "数据表字段信息无效", "数据表字段信息无效"),
    CODE_DATA_MANAGE_DATA_TABLE_COLUMN_DUPLICATE(2312, "存在重复字段信息", "存在重复字段信息"),
    CODE_DATA_MANAGE_DATA_TABLE_COLUMN_INVALID_NAME(2313, "字段名无效", "字段名无效"),
    CODE_DATA_MANAGE_DATA_TABLE_COLUMN_INVALID_TITLE(2314, "字段中文名无效", "字段中文名无效"),
    CODE_DATA_MANAGE_DATA_TABLE_COLUMN_INVALID_TYPE(2315, "字段类型无效", "字段类型无效"),
    CODE_DATA_MANAGE_DATA_TABLE_COLUMN_INVALID_DESCRIPTION(2316, "字段描述无效", "字段描述无效"),
    CODE_DATA_MANAGE_DATA_TABLE_COLUMN_INVALID_SECURITY_LEVEL(2317, "字段安全等级无效", "字段安全等级无效"),
    CODE_DATA_MANAGE_DATA_TABLE_COLUMN_INVALID_MASKING_TYPE(2318, "字段脱敏方式无效", "字段脱敏方式无效"),
    CODE_DATA_MANAGE_DATA_TABLE_DUPLICATE(2321, "数据表已存在", "数据表已存在"),
    CODE_DATA_MANAGE_DATA_TABLE_NOT_EXISTS(2322, "数据表不存在", "数据表不存在"),
    CODE_DATA_MANAGE_DATA_TABLE_QUERY_FAILED(2331, "数据查询失败", "数据查询失败"),
    CODE_DATA_MANAGE_DATA_TABLE_WRITE_SAMPLE_FAILED(2331, "样例数据写入失败", "样例数据写入失败"),
    CODE_DATA_MANAGE_DATA_TABLE_INVALID_SECURITY_CLASSIFICATION(2332, "数据分级无效", "数据分级无效"),
    CODE_DATA_MARKET_PUBLISH_INVALID_USER(3001, "操作用户无效", "操作用户无效"),
    CODE_DATA_MARKET_PUBLISH_INVALID_TAG(3002, "数据分类无效", "数据分类无效"),
    CODE_DATA_MARKET_PUBLISH_INVALID_DATA_UUID(3003, "数据ID无效", "数据ID无效"),
    CODE_DATA_MARKET_PUBLISH_INVALID_DATA_TITLE(3004, "数据名称无效", "数据名称无效"),
    CODE_DATA_MARKET_PUBLISH_INVALID_DATA_DESCRIPTION(3005, "数据描述无效", "数据描述无效"),
    CODE_DATA_MARKET_PUBLISH_INVALID_DATA_ORGANIZATION(3006, "发布组织无效", "发布组织无效"),
    CODE_DATA_MARKET_PUBLISH_INVALID_DATA_CONTENT(3007, "发布信息无效", "发布信息无效"),
    CODE_DATA_MARKET_PUBLISH_DUPLICATE(3011, "发布申请已存在", "发布申请已存在"),
    CODE_DATA_MARKET_PUBLISH_NOT_EXISTS(3012, "发布申请不存在", "发布申请不存在"),
    CODE_DATA_MARKET_PUBLISH_ALREADY_AUDIT(3021, "发布申请已审核", "发布申请已审核"),
    CODE_DATA_MARKET_MARKET_DUPLICATE(3101, "数据已存在", "数据已存在"),
    CODE_DATA_MARKET_MARKET_NOT_EXISTS(3102, "数据不存在", "数据不存在"),
    CODE_DATA_MARKET_MARKET_IS_AUTH(3103, "数据已授权使用", "数据已授权使用"),
    CODE_CONFIG_SECURITY_KEY_EXPIRED(4001, "密钥已过期，请重新获取", "密钥已过期，请重新获取"),
    CODE_AUDIT_FLOW_NOT_EXISTS_EXCEPTION(5001, "流程不存在", "流程不存在"),
    CODE_AUDIT_FLOW_NOT_DEFINITION_EXCEPTION(5002, "流程未定义", "流程未定义"),
    CODE_AUDIT_FLOW_AUDITED_EXCEPTION(5003, "流程已审核", "流程已审核"),
    CODE_DATA_AUTH_DATA_TABLE_APPLY_INVALID_USER(6001, "操作用户无效", "操作用户无效"),
    CODE_DATA_AUTH_DATA_TABLE_APPLY_INVALID_AUTH_TYPE(6002, "申请授权模式无效", "申请授权模式无效"),
    CODE_DATA_AUTH_DATA_TABLE_APPLY_INVALID_AUTH_GROUP(6003, "申请组无效", "申请组无效"),
    CODE_DATA_AUTH_DATA_TABLE_APPLY_INVALID_AUTH_USER(6004, "申请用户无效", "申请用户无效"),
    CODE_DATA_AUTH_DATA_TABLE_APPLY_INVALID_DATA(6005, "申请数据无效", "申请数据无效"),
    CODE_DATA_AUTH_DATA_TABLE_APPLY_INVALID_PURPOSE(6006, "申请用途无效", "申请用途无效"),
    CODE_DATA_AUTH_DATA_TABLE_APPLY_INVALID_AUTH_PERIOD(6007, "申请时长无效", "申请时长无效"),
    CODE_DATA_AUTH_DATA_TABLE_APPLY_INVALID_SECURITY_LEVEL(6008, "申请安全等级无效", "申请安全等级无效"),
    CODE_DATA_AUTH_DATA_TABLE_APPLY_DUPLICATE(6011, "授权申请已存在", "授权申请已存在"),
    CODE_DATA_AUTH_DATA_TABLE_APPLY_NOT_EXISTS(6012, "授权申请不存在", "授权申请不存在"),
    CODE_DATA_AUTH_DATA_TABLE_APPLY_ALREADY_AUDIT(6021, "授权申请已审核", "授权申请已审核"),
    CODE_DATA_AUTH_DATA_TABLE_DUPLICATE(6101, "授权已存在", "授权已存在"),
    CODE_DATA_AUTH_DATA_TABLE_NOT_EXISTS(6102, "授权不存在", "授权不存在"),
    CODE_DATA_AUTH_DATA_TABLE_EXPIRED(6103, "授权已过期", "授权已过期"),
    CODE_FILE_MANAGE_UPLOAD_OSS_NOT_EXISTS(7001, "对象存储数据源不存在", "对象存储数据源不存在"),
    CODE_FILE_MANAGE_UPLOAD_OSS_DUPLICATE(7002, "对象存储数据源已存在", "对象存储数据源已存在"),
    CODE_FILE_MANAGE_UPLOAD_OSS_CONNECTION_FAILED(7003, "连接对象存储数据源失败", "连接对象存储数据源失败"),
    CODE_FILE_MANAGE_UPLOAD_FILE_NOT_EXISTS(7011, "文件不存在", "文件不存在"),
    CODE_FILE_MANAGE_UPLOAD_FILE_INVALID_INFO(7012, "文件信息无效", "文件信息无效"),
    CODE_FILE_MANAGE_UPLOAD_FILE_INVALID_PATH(7013, "文件路径无效", "文件路径无效"),
    CODE_FILE_MANAGE_UPLOAD_FILE_INVALID_NAME(7014, "文件名无效", "文件名无效"),
    CODE_FILE_MANAGE_RESULT_OSS_NOT_EXISTS(7101, "对象存储数据源不存在", "对象存储数据源不存在"),
    CODE_FILE_MANAGE_RESULT_OSS_DUPLICATE(7102, "对象存储数据源已存在", "对象存储数据源已存在"),
    CODE_FILE_MANAGE_RESULT_OSS_CONNECTION_FAILED(7103, "连接对象存储数据源失败", "连接对象存储数据源失败"),
    CODE_FILE_MANAGE_RESULT_FILE_NOT_EXISTS(7111, "文件不存在", "文件不存在"),
    CODE_FILE_MANAGE_RESULT_FILE_INVALID_INFO(7112, "文件信息无效", "文件信息无效"),
    CODE_FILE_MANAGE_RESULT_FILE_INVALID_PATH(7113, "文件路径无效", "文件路径无效"),
    CODE_FILE_MANAGE_RESULT_FILE_INVALID_NAME(7114, "文件名无效", "文件名无效"),
    CODE_FILE_MANAGE_RESULT_NOT_EXISTS(7151, "结果数据不存在", "结果数据不存在"),
    CODE_FILE_MANAGE_RESULT_DUPLICATE(7152, "还有未处理完成的结果数据", "还有未处理完成的结果数据"),
    CODE_FILE_MANAGE_RESULT_ALREADY_AUDIT(7153, "结果数据已审核", "结果数据已审核"),
    CODE_FILE_MANAGE_EXPORT_FILE_NOT_EXISTS(7211, "文件不存在", "文件不存在"),
    CODE_FILE_MANAGE_EXPORT_FILE_INVALID_INFO(7212, "文件信息无效", "文件信息无效"),
    CODE_FILE_MANAGE_EXPORT_FILE_INVALID_PATH(7213, "文件路径无效", "文件路径无效"),
    CODE_FILE_MANAGE_EXPORT_FILE_INVALID_NAME(7214, "文件名无效", "文件名无效"),
    CODE_FILE_MANAGE_EXPORT_TASK_NOT_EXISTS(7261, "导出数据任务不存在", "导出数据任务不存在"),
    CODE_FILE_MANAGE_EXPORT_TASK_SYNCING(7262, "导出数据任务正在执行中", "导出数据任务正在执行中"),
    CODE_FILE_MANAGE_EXPORT_TASK_SYNCED(7263, "导出数据任务已完成", "导出数据任务已完成"),
    CODE_FILE_MANAGE_EXPORT_TASK_FILE_SYNC_FAILED(7264, "文件导出失败", "文件导出失败"),
    CODE_FILE_MANAGE_EXPORT_TASK_FILE_SYNCING(7265, "文件导出中", "文件导出中"),
    CODE_FILE_MANAGE_IMPORT_FILE_NOT_EXISTS(7311, "文件不存在", "文件不存在"),
    CODE_FILE_MANAGE_IMPORT_FILE_INVALID_INFO(7312, "文件信息无效", "文件信息无效"),
    CODE_FILE_MANAGE_IMPORT_FILE_INVALID_PATH(7313, "文件路径无效", "文件路径无效"),
    CODE_FILE_MANAGE_IMPORT_FILE_INVALID_NAME(7314, "文件名无效", "文件名无效"),
    CODE_FILE_MANAGE_IMPORT_TASK_NOT_EXISTS(7361, "导入数据任务不存在", "导入数据任务不存在"),
    CODE_FILE_MANAGE_IMPORT_TASK_SYNCING(7362, "导入数据任务正在执行中", "导入数据任务正在执行中"),
    CODE_FILE_MANAGE_IMPORT_TASK_SYNCED(7363, "导入数据任务已完成", "导入数据任务已完成"),
    CODE_FILE_MANAGE_IMPORT_TASK_FILE_SYNC_FAILED(7364, "文件导入失败", "文件导入失败"),
    CODE_FILE_MANAGE_IMPORT_TASK_FILE_SYNCING(7365, "文件导入中", "文件导入中"),
    CODE_FILE_MANAGE_IMPORT_TASK_FAILED_DATASOURCE_CONNECTION(7371, "数据源连接失败", "数据源连接失败"),
    CODE_FILE_MANAGE_IMPORT_TASK_FAILED_FILE_SYNCING(7372, "文件传输失败", "文件传输失败"),
    CODE_FILE_MANAGE_EXPORT_OSS_NOT_EXISTS(7401, "对象存储数据源不存在", "对象存储数据源不存在"),
    CODE_FILE_MANAGE_EXPORT_OSS_DUPLICATE(7402, "对象存储数据源已存在", "对象存储数据源已存在"),
    CODE_FILE_MANAGE_EXPORT_OSS_CONNECTION_FAILED(7403, "连接对象存储数据源失败", "连接对象存储数据源失败"),
    CODE_FILE_MANAGE_EXPORT_DATA_TABLE_FAILED(7411, "授权数据表导出失败", "授权数据表导出失败"),
    CODE_FILE_MANAGE_HOST_CONNECTION_FAILED(7501, "连接沙箱失败", "连接沙箱失败"),
    CODE_FILE_MANAGE_HOST_EMPTY_PATH(7502, "沙箱路径下没有文件或文件为空", "沙箱路径下没有文件或文件为空"),
    CODE_FILE_MANAGE_HOST_INVALID_INFO(7503, "沙箱信息无效", "沙箱信息无效"),
    CODE_FILE_MANAGE_HOST_INVALID_IP(7504, "沙箱地址无效", "沙箱地址无效"),
    CODE_FILE_MANAGE_HOST_INVALID_USERNAME(7505, "沙箱用户无效", "沙箱用户无效"),
    CODE_FILE_MANAGE_HOST_INVALID_PASSWORD(7506, "沙箱密码无效", "沙箱密码无效"),
    CODE_FILE_MANAGE_HOST_INVALID_OS_TYPE(7507, "沙箱系统类型无效", "沙箱系统类型无效"),
    CODE_CONFIGURATION_MANAGER_DATA_CATEGORY_NOT_EXITS(8001, "数据分类不存在", "数据分类不存在"),
    CODE_CONFIGURATION_MANAGER_DATA_CATEGORY_TYPE_NOT_EXITS(8002, "数据分类类型不存在", "数据分类类型不存在"),
    CODE_CONFIGURATION_MANAGER_DATA_CATEGORY_STATUS_NOT_EXITS(8003, "数据分类状态不存在", "数据分类状态不存在"),
    CODE_CONFIGURATION_MANAGER_DATA_STRATEGY_EFFECT_TIME_OUT_RANG(8101, "数据策略有效时间超出有效范围", "数据策略有效时间超出有效范围"),
    CODE_CONFIGURATION_MANAGER_IMAGE_CLIENT_CREATE_ERROR(8102, "操作失败", "返回状态码不为0"),
    CODE_CONFIGURATION_MANAGER_IMAGE_CLIENT_CREATE_CONNECT_ERROR(8103, "操作失败", "请求连接客户端失败"),
    CODE_CONFIGURATION_MANAGER_NETWORK_POLICY_CLIENT_CREATE_ERROR(8104, "操作失败", "返回状态码不为0"),
    CODE_CONFIGURATION_MANAGER_NETWORK_POLICY_CLIENT_CREATE_CONNECT_ERROR(8105, "操作失败", "请求连接客户端失败"),
    CODE_CONFIGURATION_MANAGER_RESOURCE_ALLOCATION_RESOURCE_NOT_ENOUGH(8106, "资源不足", "资源不足"),
    CODE_CONFIGURATION_MANAGER_RESOURCE_ALLOCATION_ORG_ID_EXITS(8107, "组织id已经存在", "组织id已经存在"),
    CODE_CONFIGURATION_MANAGER_RESOURCE_ALLOCATION_USER_ID_EXITS(8108, "用户id已经存在", "用户id已经存在"),
    CODE_SCORE_MANAGER_SCHEDULER_PARAM_ERROR(9001, "调度类型参数错误", "调度类型参数错误"),
    CODE_SCORE_MANAGER_SCORE_SETTING_NOT_EXITS(9002, "评分配置不存在", "评分配置不存在"),
    CODE_SCORE_MANAGER_SCORE_SETTING_STATUS_ERROR(9003, "评分配置状态错误", "评分配置状态错误"),
    CODE_REPORT_CHART_PANEL_TYPE_UNKNOWN(9001, "图表类型不存在", "图表类型不存在"),
    CODE_REPORT_CHART_PANEL_DOWNLOAD_TYPE_UNKNOWN(9002, "图表下载类型不存在", "图表下载类型不存在"),
    CODE_REPORT_CHART_PANEL_STYLE_UNKNOWN(9003, "图表样式不存在", "图表样式不存在"),
    CODE_REPORT_CHART_PANEL_UNKNOWN(9004, "图表不存在", "图表不存在"),
    CODE_REPORT_CHART_PANEL_TYPE_UNSUPPORTED(9005, "当前图表不支持该类型", "当前图表不支持该类型"),
    CODE_REPORT_CHART_PANEL_DOWNLOAD_TYPE_UNSUPPORTED(9006, "当前图表不支持该下载方式", "当前图表不支持该下载方式"),
    CODE_REPORT_CHART_PANEL_STYLE_UNSUPPORTED(9007, "当前图表不支持该样式", "当前图表不支持该样式"),
    CODE_REPORT_CHART_PANEL_START_TIME_INVALID(9008, "起始时间无效", "起始时间无效"),
    CODE_REPORT_CHART_PANEL_END_TIME_INVALID(9009, "结束时间无效", "结束时间无效"),
    CODE_REPORT_CHART_PANEL_ORG_ID_INVALID(9010, "组织信息无效", "组织信息无效"),
    CODE_REPORT_CHART_PANEL_GET_CHART_DATA_FAILED(9011, "获取图表数据失败", "获取图表数据失败"),
    CODE_SCORE_APP_TOKEN_INVALID(10000, "Token无效", "Token无效"),
    CODE_SCORE_APP_FILE_UPLOAD_ERROR(10001, "文件上传失败", "文件上传失败"),
    CODE_SCORE_APP_FILE_DOWNLOAD_ERROR(10002, "文件下载失败", "文件下载失败"),
    CODE_SCORE_APP_GET_USER_ERROR(10002, "获取用户失败", "获取用户失败"),
    CODE_SCORE_APP_SUBMIT_ERROR(10003, "提交评分失败", "提交评分失败"),
    CODE_MPC_NODE_NAME_DUPLICATE(11001, "节点名称重复", "节点名称重复"),
    CODE_MPC_ALGORITHM_NAME_DUPLICATE(11001, "算法名称重复", "算法名称重复"),
    CODE_MPC_SERVICE_ERROR(11009, "服务错误", "服务错误");

    private int code;
    private String description;
    private String defaultMessage;

    private ResponseCode(int code, String description, String defaultMessage) {
        this.code = code;
        this.description = description;
        this.defaultMessage = defaultMessage;
    }

    @JsonValue
    public Integer getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDefaultMessage() {
        return this.defaultMessage;
    }

    public String toString() {
        return this.code + "";
    }

    public static ResponseCode parse(int code) {
        ResponseCode[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ResponseCode responseCode = var1[var3];
            if (responseCode.code == code) {
                return responseCode;
            }
        }

        return CODE_BUSINESS_ERROR;
    }

    private ResponseCode() {
    }
}
