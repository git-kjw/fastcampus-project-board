-- 123 게시글
insert into article (title, content, hashtag, created_by, modified_by, created_at, modified_at)
values ('Quisque ut erat.'
, 'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur convallis.
Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor. Morbi vel lectus in quam fringilla rhoncus.
Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci. Mauris lacinia sapien quis libero.'
, '#pink'
, 'Kamilah'
, 'Murial'
, '2021-05-30 23:53:46'
, '2021-03-10 08:48:50');

-- 1000 댓글
insert into article_comment (article_id, content, created_at, modified_at, created_by, modified_by)
values (1
  , 'Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.'
  , '2021-03-02 22:40:04'
  , '2021-04-27 15:38:09'
  , 'Lind'
  , 'Orv');