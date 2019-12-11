###<- api - >
####一、系统管理
##### 0、验证码获取
*接口地址*： /api/code <br />
*接口描述*： 验证码获取
#####请求头设置
```
```
#####   请求参数：  
```
```  
method: get
  
#####   返回格式：  
```
jpg
```  
***  
##### 0、注册用户
*接口地址*： /api/register <br />
*接口描述*： 注册用户
#####请求头设置
```
```
#####   请求参数：  
```
body：susUser对象（对象中只需传userName  userPass这两个参数）
参数：codeStr 验证码
```  
method: post
  
#####   返回格式：  
```

```  
***  
##### 1.登录(login)
*接口地址*： /oauth/token <br />
*接口描述*： 用户登录接口
#####请求头设置
```
Authorization : Basic d2Vic2l0ZTp3ZWJzaXRl
```
#####   请求参数：  
```
username : username
password : pwd
grant_type:password
scope : server 
codeStr: code
```  
method: post
  
#####   返回格式：  
```json  
{
    "access_token": "cf97b7ca-2648-4d42-b285-32267b390e58",
    "token_type": "bearer",
    "refresh_token": "779a93ec-ba46-4241-b582-e26cb1f69ce1",
    "expires_in": 39897,
    "scope": "server"
}
```  
***  
##### 2.请求页面菜单列表(此接口不需要登录，开放)
*接口地址*： /api/menuTree <br />
*接口描述*： 请求菜单列表
#####请求头设置
```
```
#####   请求参数：  
```
```  
method: get
#####   返回格式：  
```json  
{
 "success": true,
     "code": 200,
     "msg": "成功",
     "data": [
         {
             "id": 12,
             "menuPid": 0,
             "menuName": "前端技术",
             "permission": null,
             "menuUrl": null,
             "menuSort": null,
             "menuIcon": null,
             "delFlag": "0",
             "createBy": "1",
             "createTime": "2019-11-09T17:16:47",
             "updateBy": "1",
             "updateTime": "2019-11-09T17:16:50",
             "child": [
                 {
                     "id": 13,
                     "menuPid": 12,
                     "menuName": "预留1",
                     "permission": null,
                     "menuUrl": null,
                     "menuSort": null,
                     "menuIcon": null,
                     "delFlag": "0",
                     "createBy": "1",
                     "createTime": "2019-11-14T11:17:15",
                     "updateBy": "1",
                     "updateTime": "2019-11-14T11:17:52",
                     "child": null
                 }]
         {
             "id": 17,
             "menuPid": 0,
             "menuName": "后端技术",
             "permission": null,
             "menuUrl": null,
             "menuSort": null,
             "menuIcon": null,
             "delFlag": "0",
             "createBy": "1",
             "createTime": "2019-11-14T11:17:25",
             "updateBy": "1",
             "updateTime": "2019-11-14T11:18:04",
             "child": [
                 {
                     "id": 18,
                     "menuPid": 17,
                     "menuName": "预留1",
                     "permission": null,
                     "menuUrl": null,
                     "menuSort": null,
                     "menuIcon": null,
                     "delFlag": "0",
                     "createBy": "1",
                     "createTime": "2019-11-14T11:17:28",
                     "updateBy": "1",
                     "updateTime": "2019-11-14T11:18:06",
                     "child": null
                 }
             ]
 }
```  
***  
##### 3.管理员管理所有的菜单
*接口地址*： /menu/allMenuTree <br />
*接口描述*： 管理员编辑角色时获取到所有的菜单
#####请求头设置
```
Authorization   Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJsbSIsInN1YiI6InJvb3QiLCJpYXQiOjE1NzM3MDI2MTcsImV4cCI6MTU3MzcwNjIxN30.erHYeGiyPpD3177dy8Ow9PEcMY4i5F5pRLRcQQJ-FqUy8TligjGL-sa9lzKiw9sqPelu293EtFqlM-q-p4Qseg
```
#####   请求参数：  
```
```  
method: get
  
#####   返回格式：  
```json  
同接口 2
```  
***  
##### 4.用户登录时获取自己的菜单
*接口地址*： /menu/userMenuTree <br />
*接口描述*： 用户登录时获取自己的菜单
#####请求头设置
```
Authorization   Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJsbSIsInN1YiI6InJvb3QiLCJpYXQiOjE1NzM3MDI2MTcsImV4cCI6MTU3MzcwNjIxN30.erHYeGiyPpD3177dy8Ow9PEcMY4i5F5pRLRcQQJ-FqUy8TligjGL-sa9lzKiw9sqPelu293EtFqlM-q-p4Qseg
```
#####   请求参数：  
```
```  
method: get
  
#####   返回格式：  
```json  
同接口 2
```  
***  
##### 5.编辑角色时获取角色拥有的菜单
*接口地址*： /menu/roleMenuTree/{roleId} <br />
*接口描述*： 编辑角色时获取角色已经拥有的菜单吗，和接口3配合使用
#####请求头设置
```
Authorization   Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJsbSIsInN1YiI6InJvb3QiLCJpYXQiOjE1NzM3MDI2MTcsImV4cCI6MTU3MzcwNjIxN30.erHYeGiyPpD3177dy8Ow9PEcMY4i5F5pRLRcQQJ-FqUy8TligjGL-sa9lzKiw9sqPelu293EtFqlM-q-p4Qseg
```
#####   请求参数：  
```
```  
method: get
  
#####   返回格式：  
```json  
同接口 2
```  
***  
##### 6.添加菜单
*接口地址*： /menu <br />
*接口描述*： 添加菜单
#####请求头设置
```
Authorization   Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJsbSIsInN1YiI6InJvb3QiLCJpYXQiOjE1NzM3MDI2MTcsImV4cCI6MTU3MzcwNjIxN30.erHYeGiyPpD3177dy8Ow9PEcMY4i5F5pRLRcQQJ-FqUy8TligjGL-sa9lzKiw9sqPelu293EtFqlM-q-p4Qseg
```
#####   请求参数：  
```
SysMenu 实体
```  
method: post
  
#####   返回格式：  
```json  
true
```  
***  
##### 7.修改菜单
*接口地址*： /menu <br />
*接口描述*： 修改菜单
#####请求头设置
```
Authorization   Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJsbSIsInN1YiI6InJvb3QiLCJpYXQiOjE1NzM3MDI2MTcsImV4cCI6MTU3MzcwNjIxN30.erHYeGiyPpD3177dy8Ow9PEcMY4i5F5pRLRcQQJ-FqUy8TligjGL-sa9lzKiw9sqPelu293EtFqlM-q-p4Qseg
```
#####   请求参数：  
```
SysMenu 实体
```  
method: put
  
#####   返回格式：  
```json  
true
```  
***  
##### 8.删除菜单
*接口地址*： /menu/id <br />
*接口描述*： 删除菜单
#####请求头设置
```
Authorization   Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJsbSIsInN1YiI6InJvb3QiLCJpYXQiOjE1NzM3MDI2MTcsImV4cCI6MTU3MzcwNjIxN30.erHYeGiyPpD3177dy8Ow9PEcMY4i5F5pRLRcQQJ-FqUy8TligjGL-sa9lzKiw9sqPelu293EtFqlM-q-p4Qseg
```
#####   请求参数：  
```
路径参数id
```  
method: delete
  
#####   返回格式：  
```json  
true
```  
***  
##### 9.分页查询用户列表
*接口地址*： /user/page <br />
*接口描述*： 查询用户
#####请求头设置
```
Authorization   Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJsbSIsInN1YiI6InJvb3QiLCJpYXQiOjE1NzM3MDI2MTcsImV4cCI6MTU3MzcwNjIxN30.erHYeGiyPpD3177dy8Ow9PEcMY4i5F5pRLRcQQJ-FqUy8TligjGL-sa9lzKiw9sqPelu293EtFqlM-q-p4Qseg
```
#####   请求参数：  
```
分页参数 page 
SysUser 实体(用于条件查询)
```  
method: get
  
#####   返回格式：  
```json  
{
、、、
}
```  
***  
##### 10.通过Id查询用户
*接口地址*： /user/id <br />
*接口描述*： 查询用户
#####请求头设置
```
Authorization   Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJsbSIsInN1YiI6InJvb3QiLCJpYXQiOjE1NzM3MDI2MTcsImV4cCI6MTU3MzcwNjIxN30.erHYeGiyPpD3177dy8Ow9PEcMY4i5F5pRLRcQQJ-FqUy8TligjGL-sa9lzKiw9sqPelu293EtFqlM-q-p4Qseg
```
#####   请求参数：  
```
id 路径参数
```  
method: get
  
#####   返回格式：  
```json  
{
、、、
}
```  
***  
##### 11.添加用户
*接口地址*： /user <br />
*接口描述*： 添加用户
#####请求头设置
```
Authorization   Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJsbSIsInN1YiI6InJvb3QiLCJpYXQiOjE1NzM3MDI2MTcsImV4cCI6MTU3MzcwNjIxN30.erHYeGiyPpD3177dy8Ow9PEcMY4i5F5pRLRcQQJ-FqUy8TligjGL-sa9lzKiw9sqPelu293EtFqlM-q-p4Qseg
```
#####   请求参数：  
```
SysUser 实体
```  
method: post
  
#####   返回格式：  
```json  
{
、、、
}
```  
***  
##### 12.修改用户
*接口地址*： /user <br />
*接口描述*：修改
#####请求头设置
```
Authorization   Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJsbSIsInN1YiI6InJvb3QiLCJpYXQiOjE1NzM3MDI2MTcsImV4cCI6MTU3MzcwNjIxN30.erHYeGiyPpD3177dy8Ow9PEcMY4i5F5pRLRcQQJ-FqUy8TligjGL-sa9lzKiw9sqPelu293EtFqlM-q-p4Qseg
```
#####   请求参数：  
```
SysUser 实体
```  
method: put
  
#####   返回格式：  
```json  
{
、、、
}
```  
***  
##### 13.删除用户
*接口地址*： /user/id <br />
*接口描述*：修改
#####请求头设置
```
Authorization   Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJsbSIsInN1YiI6InJvb3QiLCJpYXQiOjE1NzM3MDI2MTcsImV4cCI6MTU3MzcwNjIxN30.erHYeGiyPpD3177dy8Ow9PEcMY4i5F5pRLRcQQJ-FqUy8TligjGL-sa9lzKiw9sqPelu293EtFqlM-q-p4Qseg
```
#####   请求参数：  
```
id 路径参数
```  
method: delete
  
#####   返回格式：  
```json  
{
、、、
}
```  
***  
##### 14.角色分页列表
*接口地址*： /role/page <br />
*接口描述*：获取角色分页列表<br />
*接口权限标识*：role_page
#####请求头设置
```
Authorization   Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJsbSIsInN1YiI6InJvb3QiLCJpYXQiOjE1NzM3MDI2MTcsImV4cCI6MTU3MzcwNjIxN30.erHYeGiyPpD3177dy8Ow9PEcMY4i5F5pRLRcQQJ-FqUy8TligjGL-sa9lzKiw9sqPelu293EtFqlM-q-p4Qseg
```
#####   请求参数：  
```
```  
method: get
  
#####   返回格式：  
```json  
{
、、、
}
```  
*** 
##### 15.通过id获取角色
*接口地*： /role/id <br />
*接口描述*：获取角色 <br />
*接口权限标识*：get_role
#####请求头设置
```
Authorization   Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJsbSIsInN1YiI6InJvb3QiLCJpYXQiOjE1NzM3MDI2MTcsImV4cCI6MTU3MzcwNjIxN30.erHYeGiyPpD3177dy8Ow9PEcMY4i5F5pRLRcQQJ-FqUy8TligjGL-sa9lzKiw9sqPelu293EtFqlM-q-p4Qseg
```
#####   请求参数：  
```
id 路径参数
```  
method: get
  
#####   返回格式：  
```json  
{
、、、
}
```  
***  
##### 16.添加角色
*接口地*： /role <br />
*接口描述*：添加角色 <br />
*接口权限标识*：add_role
#####请求头设置
```
Authorization   Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJsbSIsInN1YiI6InJvb3QiLCJpYXQiOjE1NzM3MDI2MTcsImV4cCI6MTU3MzcwNjIxN30.erHYeGiyPpD3177dy8Ow9PEcMY4i5F5pRLRcQQJ-FqUy8TligjGL-sa9lzKiw9sqPelu293EtFqlM-q-p4Qseg
```
#####   请求参数：  
```
sysRole
```  
method: post
  
#####   返回格式：  
```json  
{
、、、
}
```  
***  
##### 17.修改角色
*接口地*： /role <br />
*接口描述*：修改角色和给角色赋权两个功能合并，都在修改角色是进行修改 <br />
*接口权限标识*：edit_role
#####请求头设置
```
Authorization   Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJsbSIsInN1YiI6InJvb3QiLCJpYXQiOjE1NzM3MDI2MTcsImV4cCI6MTU3MzcwNjIxN30.erHYeGiyPpD3177dy8Ow9PEcMY4i5F5pRLRcQQJ-FqUy8TligjGL-sa9lzKiw9sqPelu293EtFqlM-q-p4Qseg
```
#####   请求参数：  
```
sysRole 角色实体
Integer[] menuIds 修改后角色拥有的菜单id
```  
method: put
  
#####   返回格式：  
```json  
{
、、、
}
```  
***  
##### 18.删除角色
*接口地*： /role/id <br />
*接口描述*：删除角色 <br />
*接口权限标识*：delete_role
#####请求头设置
```
Authorization   Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJsbSIsInN1YiI6InJvb3QiLCJpYXQiOjE1NzM3MDI2MTcsImV4cCI6MTU3MzcwNjIxN30.erHYeGiyPpD3177dy8Ow9PEcMY4i5F5pRLRcQQJ-FqUy8TligjGL-sa9lzKiw9sqPelu293EtFqlM-q-p4Qseg
```
#####   请求参数：  
```
id 路径参数
```  
method: delete
  
#####   返回格式：  
```json  
{
、、、
}
```  
*** 




