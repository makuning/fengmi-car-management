package cn.insectmk.sys.controller;

import cn.insectmk.sys.domain.DataGridView;
import cn.insectmk.sys.domain.RoleVo;
import cn.insectmk.sys.domain.UserVo;
import cn.insectmk.sys.service.RoleService;
import cn.insectmk.sys.service.UserService;
import cn.insectmk.sys.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 用户模块控制器
 * @Author makun
 * @Date 2023/7/4 20:35
 * @Version 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 重置密码
     * @param userVo
     * @return
     */
    @RequestMapping("resetUserPwd")
    public ResultObj resetUserPwd(UserVo userVo){
        try {
            this.userService.resetUserPwd(userVo.getUserid());
            return ResultObj.RESET_SUCCESS;
        }catch (Exception e){
            return ResultObj.RESET_ERROR;
        }
    }

    /**
     * 批量删除用户
     * @param userVo
     * @return
     */
    @RequestMapping("deleteBatchUser")
    public ResultObj deleteBatchUser(UserVo userVo){
        try {
            this.userService.deleteBatchUser(userVo.getIds());
            return ResultObj.DELETE_SUCCESS;
        }catch (Exception e){
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 删除用户
     * @param userid
     * @return
     */
    @RequestMapping("deleteUser")
    public ResultObj deleteUser(int userid){
        try {
            this.userService.deleteUser(userid);
            return ResultObj.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 修改用户
     * @param userVo
     * @return
     */
    @RequestMapping("updateUser")
    public ResultObj updateUser(UserVo userVo){
        try {
            this.userService.updateUser(userVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 添加用户
     * @param userVo
     * @return
     */
    @RequestMapping("addUser")
    public ResultObj addUser(UserVo userVo){
        try {
            this.userService.addUser(userVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 加载用户列表返回DataGridView
     * @param userVo
     * @return
     */
    @RequestMapping("loadAllUser")
    public DataGridView loadAllUser(UserVo userVo){
        return this.userService.queryAllUser(userVo);
    }
}
