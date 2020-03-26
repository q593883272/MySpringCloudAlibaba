-- 注意此处0.3.0+ 增加唯一索引 ux_undo_log
CREATE TABLE `undo_log`
(
    `id`            bigint(20)   NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `branch_id`     bigint(20)   NOT NULL UNIQUE,
    `xid`           varchar(100) NOT NULL UNIQUE,
    `context`       varchar(128) NOT NULL,
    `rollback_info` longblob     NOT NULL,
    `log_status`    int(11)      NOT NULL,
    `log_created`   datetime     NOT NULL,
    `log_modified`  datetime     NOT NULL,
    `ext`           varchar(100) DEFAULT NULL
)