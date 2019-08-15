package com.aotain.nms.common.config.log;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo class
 *
 * @author bang
 * @date 2019/05/07
 */
public enum SystemActionLogType {
    CREATE("增加"),
    DELETE("删除"),
    UPDATE("修改"),
    READ("查询"),
    MERGE("合并"),
    REPORT("上报"),
    RESEND("重发"),
    DEAL("处置"),
    RECOVER("恢复"),
    IMPORT("导入"),
    IMPORT_DEL("删除导入"),
    EXPORT("导出"),
    APPROVE("预审"),
    LOGIN("登录"),
    LOGINOUT("退出"),
    CASCADEAPPROVE("级联预审"),
    REVOKEAPPROVE("撤销预审"),
    DETAIINFO("详情查看"),
    CHANGE_NATURE("属性变更"),
    DOWNLOAD_TEMPLATE("模板下载"),
    DOWNLOAD_ERROR_FILE("错误文件下载"),
    DOWNLOAD_CHECK_RESULT("核验结果下载");

    private String description;

    public String getDescription() {
        return this.description;
    }

    private SystemActionLogType(String description) {
        this.description = description;
    }

    public static List<LabelValueBean> getSystemActionLogTypes() {
        List<LabelValueBean> lvbs = new ArrayList();
        SystemActionLogType[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            SystemActionLogType item = var1[var3];
            LabelValueBean lvb = new LabelValueBean();
            lvb.setItemLabel(item.getDescription());
            lvb.setItemValue(item.ordinal() + "");
            lvbs.add(lvb);
        }

        return lvbs;
    }

    public static SystemActionLogType valueOf(int ordinal) {
        SystemActionLogType[] systemActionLogTypes = values();
        if (ordinal >= 0 && ordinal < systemActionLogTypes.length) {
            return systemActionLogTypes[ordinal];
        } else {
            throw new IndexOutOfBoundsException("Invalid ordinal");
        }
    }
}
