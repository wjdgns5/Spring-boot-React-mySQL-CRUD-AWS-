select *
from user;

select *
from board;

SELECT b.*, u.*
FROM board b
INNER JOIN user u ON b.user_id = u.id;





