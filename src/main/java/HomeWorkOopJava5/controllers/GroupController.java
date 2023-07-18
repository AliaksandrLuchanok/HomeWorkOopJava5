package HomeWorkOopJava5.controllers;

import HomeWorkOopJava5.models.User;
import HomeWorkOopJava5.services.GroupService;

import java.util.List;

/**
 * Будет работать сразу с двумя сервисами (педагог - студенты)
 */
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    public List<User> getAllUserFromGroup (String groupTitle){
        return groupService.getAllUsersFromGroup(groupTitle);
    }
    public List<User> setGroupUseById(Long id, String group) {
        return groupService.setGroupUseById(id, group);
    }
    public Long getIdGroup(){
        return groupService.getIdGroup();
    }



}
