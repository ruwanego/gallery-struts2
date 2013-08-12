insert into resource_type(`type`)
values ('Album'), ('Comic'), ('Image'), ('Nsfw'), ('Tag');

insert into album_type(`type`)
values ('Album'), ('Comic');

insert into image_type(`type`)
values ('Image'), ('Nsfw');

insert into tag_type(`type`)
values ('Tag');

insert into resource(`type`, `name`, `created`)
values ('Album', 'Originals', NOW());

insert into album(`id`, `type`, `description`, `slug`)
values (1, 'Album', 'Original art', 'original-art');

insert into resource(`type`, `name`, `created`)
values ('Album', 'Peacemakers', NOW());

insert into album(`id`, `type`, `parent_id`, `parent_type`, `description`, `slug`)
values (2, 'Album', 1, 'Album', 'A story created by Erin and Lani', 'peacemakers');