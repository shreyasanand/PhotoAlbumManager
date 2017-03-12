DROP TABLE IF EXISTS albums;
CREATE TABLE albums (
  id long(11) NOT NULL,
  title varchar(100) NOT NULL,
  user_id long(11),
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS photos;
CREATE TABLE photos (
  album_id long(11),
  id long(11) NOT NULL,
  title varchar(100) NOT NULL,
  url varchar(200) NOT NULL,
  thumbnail_url varchar(200),
  PRIMARY KEY (id),
  CONSTRAINT fk_album_id FOREIGN KEY (album_id) REFERENCES albums (id) ON DELETE CASCADE ON UPDATE CASCADE
);