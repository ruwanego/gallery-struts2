insert ignore into resource_type(`type`)
values ('Album'), ('Comic'), ('Image'), ('Nsfw'), ('Tag'), ('Admin');

insert ignore into album_type(`type`)
values ('Album'), ('Comic');

insert ignore into image_type(`type`)
values ('Image'), ('Nsfw');

insert ignore into tag_type(`type`)
values ('Tag');

insert ignore into resource(`type`, `name`, `created`)
values ('Album', 'Originals', NOW());

insert ignore into album(`id`, `type`, `description`, `slug`)
values (1, 'Album', 'Original art', 'original-art');

insert ignore into resource(`type`, `name`, `created`)
values ('Album', 'Peacemakers', NOW());

insert ignore into album(`id`, `type`, `parent_id`, `parent_type`, `description`, `slug`)
values (2, 'Album', 1, 'Album', 'A story created by Erin and Lani', 'peacemakers');

insert ignore into user_type(`type`)
  values ('Admin');