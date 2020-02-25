CREATE TABLE room_booking
(
  id bigint NOT NULL,
  username character varying(500),
  room_label character varying(50),
  start_date timestamp with time zone,
  end_date timestamp with time zone,
  CONSTRAINT pk_roombooking PRIMARY KEY (id)
);

CREATE SEQUENCE rb_sequence START WITH 1 INCREMENT BY 1;