--创建用户账号表
drop table if exists user_accounts;
create table user_accounts (
   id                   SERIAL not null,
   user_name            VARCHAR(64)            null,
   phone                VARCHAR(11)            null,
   email                VARCHAR(64)             null,
   salt                 VARCHAR(128)            null,
   password             VARCHAR(256)            null,
   status               VARCHAR(2)            null,
   account_type         VARCHAR(2)            null,
   created_id           INT4                 null,
   last_modify_id       INT4                 null,
   created_time         TIMESTAMP            null,
   last_modify_time     TIMESTAMP            null,
   version_num          INT4                 null,
   deleted              VARCHAR(1)              null,
   is_valid            VARCHAR(1)              null,
    CONSTRAINT "user_accounts_pkey" PRIMARY KEY ("id")
);
comment on table user_accounts is '用户账号表';
comment on column user_accounts.id is 'id';
comment on column user_accounts.user_name is '用户名称';
comment on column user_accounts.phone is '手机号码';
comment on column user_accounts.email is '电子邮件地址';
comment on column user_accounts.salt is '盐';
comment on column user_accounts.password is '密码';
comment on column user_accounts.status is '状态，0：禁用，1：启用';
comment on column user_accounts.account_type is '账号类型';
comment on column user_accounts.created_id is '创建人ID';
comment on column user_accounts.last_modify_id is '最后修改人的ID';
comment on column user_accounts.created_time is '创建时间';
comment on column user_accounts.last_modify_time is '最后修改时间';
comment on column user_accounts.version_num is '版本号';
comment on column user_accounts.deleted is '是否逻辑删除';
comment on column user_accounts.is_valid is '是否有效';

--创建用户角色表
drop table if exists user_roles;
create table user_roles (
   id                   SERIAL not null,
   role_name            VARCHAR(64)            null,
   describes            VARCHAR(256)            null,
   status               VARCHAR(2)            null,
   roles_type           VARCHAR(2)            null,
   created_id           INT4                 null,
   last_modify_id       INT4                 null,
   created_time         TIMESTAMP            null,
   last_modify_time     TIMESTAMP            null,
   version_num          INT4                 null,
   deleted              VARCHAR(1)              null,
   is_valid            VARCHAR(1)              null,
    CONSTRAINT "user_roles_pkey" PRIMARY KEY ("id")
);
comment on table user_roles is '用户角色表';
comment on column user_roles.id is 'id';
comment on column user_roles.role_name is '角色名称';
comment on column user_roles.describes is '角色描述';
comment on column user_roles.status is '状态，0：禁用，1：启用';
comment on column user_roles.roles_type is '角色类型';
comment on column user_roles.created_id is '创建人ID';
comment on column user_roles.last_modify_id is '最后修改人的ID';
comment on column user_roles.created_time is '创建时间';
comment on column user_roles.last_modify_time is '最后修改时间';
comment on column user_roles.version_num is '版本号';
comment on column user_roles.deleted is '是否逻辑删除';
comment on column user_roles.is_valid is '是否有效';

--创建用户权限表
drop table if exists user_permissions;
create table user_permissions (
   id                   SERIAL not null,
   url                  VARCHAR(256)            null,
   method               VARCHAR(64)            null,
   describes            VARCHAR(256)            null,
   status               VARCHAR(2)            null,
   parent_id            INT4                 null,
   created_id           INT4                 null,
   last_modify_id       INT4                 null,
   created_time         TIMESTAMP            null,
   last_modify_time     TIMESTAMP            null,
   version_num          INT4                 null,
   deleted              VARCHAR(1)              null,
   is_valid            VARCHAR(1)              null,
    CONSTRAINT "user_permissions_pkey" PRIMARY KEY ("id")
);
comment on table user_permissions is '用户权限表';
comment on column user_permissions.id is 'id';
comment on column user_permissions.url is '请求路径';
comment on column user_permissions.method is '请求风格';
comment on column user_permissions.describes is '功能描述';
comment on column user_permissions.status is '状态，0：禁用，1：启用';
comment on column user_permissions.parent_id is '上级ID';
comment on column user_permissions.created_id is '创建人ID';
comment on column user_permissions.last_modify_id is '最后修改人的ID';
comment on column user_permissions.created_time is '创建时间';
comment on column user_permissions.last_modify_time is '最后修改时间';
comment on column user_permissions.version_num is '版本号';
comment on column user_permissions.deleted is '是否逻辑删除';
comment on column user_permissions.is_valid is '是否有效';

--创建用户账号角色关联表
drop table if exists user_account_role;
create table user_account_role (
   id                   SERIAL not null,
   account_id           INT4                not null,
   role_id              INT4                not null,
   created_id           INT4                 null,
   last_modify_id       INT4                 null,
   created_time         TIMESTAMP            null,
   last_modify_time     TIMESTAMP            null,
   version_num          INT4                 null,
   deleted              VARCHAR(1)              null,
   is_valid            VARCHAR(1)              null,
    CONSTRAINT "user_account_role_pkey" PRIMARY KEY ("id")
);
comment on table user_account_role is '用户账号角色关联表';
comment on column user_account_role.id is 'id';
comment on column user_account_role.account_id is '用户账号ID';
comment on column user_account_role.role_id is '用户角色ID';
comment on column user_account_role.created_id is '创建人ID';
comment on column user_account_role.last_modify_id is '最后修改人的ID';
comment on column user_account_role.created_time is '创建时间';
comment on column user_account_role.last_modify_time is '最后修改时间';
comment on column user_account_role.version_num is '版本号';
comment on column user_account_role.deleted is '是否逻辑删除';
comment on column user_account_role.is_valid is '是否有效';

--创建用户角色权限关联表
drop table if exists user_role_permission;
create table user_role_permission (
   id                   SERIAL not null,
   role_id              INT4                not null,
   permission_id        INT4                not null,
   created_id           INT4                 null,
   last_modify_id       INT4                 null,
   created_time         TIMESTAMP            null,
   last_modify_time     TIMESTAMP            null,
   version_num          INT4                 null,
   deleted              VARCHAR(1)              null,
   is_valid            VARCHAR(1)              null,
    CONSTRAINT "user_role_permission_pkey" PRIMARY KEY ("id")
);
comment on table user_role_permission is '用户账号角色关联表';
comment on column user_role_permission.id is 'id';
comment on column user_role_permission.role_id is '用户角色ID';
comment on column user_role_permission.permission_id is '用户权限ID';
comment on column user_role_permission.created_id is '创建人ID';
comment on column user_role_permission.last_modify_id is '最后修改人的ID';
comment on column user_role_permission.created_time is '创建时间';
comment on column user_role_permission.last_modify_time is '最后修改时间';
comment on column user_role_permission.version_num is '版本号';
comment on column user_role_permission.deleted is '是否逻辑删除';
comment on column user_role_permission.is_valid is '是否有效';