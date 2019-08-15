package com.aotain.nms.common.config.log;

/**
 * Demo class
 *
 * @author bang
 * @date 2019/05/07
 */
public enum LogType {
    CREATE(1),
    DELETE(3),
    UPDATE(2),
    IMPORT(4),
    EXPORT(5),
    SETTING_IT_GROUP(6),
    DOWNLOAD_TEMPLATE(7),
    DETAIL(8),
    SETTING(9),
    LAUNCH(10),
    PROHIBIT(11),
    SHIELD(12),
    RESTORE(13),
    BATCH_DELETE(14),
    READ(0);

    private int value;

    public int getValue() {
        return this.value;
    }

    private LogType(Integer value) {
        this.value = value;
    }
}
