package HomeWorkOopJava5.view;

import HomeWorkOopJava5.controllers.GroupController;
import HomeWorkOopJava5.models.User;

import java.util.List;

public class GroupView {
    private final GroupController groupController;

    public GroupView(GroupController groupController) {
        this.groupController = groupController;
    }
    public void printAllFromGroup(String groupTitle){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("СОСТАВ " + groupTitle + " группы:" + "ID - " + groupController.getIdGroup());
        var sizeGroup =  groupController.getAllUserFromGroup(groupTitle).size();
        if (sizeGroup == 0) {
        System.out.println("ДАННЫХ ПО ВВЕДЕННЫМ ПАРАМЕТРАМ НЕТ! ");
        return;

        }
        groupController.getAllUserFromGroup(groupTitle).forEach(System.out::println);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
    public List<User> setGroupUseById(Long id, String group) {
        return groupController.setGroupUseById(id, group);
    }
}
