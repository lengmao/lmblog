###<- api - >
####一、系统管理
##### 1.登录(login)
*接口地址*： /postLogin <br />
*接口描述*： 用户登录接口
#####请求头设置
```
无
```
#####   请求参数：  
```
username : username
password : pwd
```  
method: post
  
#####   返回格式：  
```json  
{
  "Token_Type": "Bearer",
  "UserName": "root",
  "Access_Token": "eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJsbSIsInN1YiI6InJvb3QiLCJpYXQiOjE1NzM3MDI2MTcsImV4cCI6MTU3MzcwNjIxN30.erHYeGiyPpD3177dy8Ow9PEcMY4i5F5pRLRcQQJ-FqUy8TligjGL-sa9lzKiw9sqPelu293EtFqlM-q-p4Qseg"
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




