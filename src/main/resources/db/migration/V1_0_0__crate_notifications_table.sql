CREATE TABLE notifications
(
    notification_id     UUID PRIMARY KEY            DEFAULT gen_random_uuid() NOT NULL,
    user_id             UUID                                                  NOT NULL,
    message             TEXT                                                  NOT NULL,
    notification_type   VARCHAR(50)                                           NOT NULL,
    notification_status VARCHAR(50)                                           NOT NULL,
    created_at          TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW(),
    updated_at          TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW()
);