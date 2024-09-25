
CREATE TRIGGER before_insert_comment
BEFORE INSERT ON comment
FOR EACH ROW
BEGIN
    -- 먼저 변수를 선언
    DECLARE new_c_idx INT;

    -- fidx에 대한 현재 최대 c_idx를 구합니다.
    SELECT IFNULL(MAX(c_idx), 0) INTO new_c_idx
    FROM comment
    WHERE f_idx = NEW.f_idx;

    -- 새로운 c_idx를 1 증가시킵니다.
    SET new_c_idx = new_c_idx + 1;

    -- 새로 삽입될 행의 c_idx 값을 설정합니다.
    SET NEW.c_idx = new_c_idx;

END;
