package project.business;

import project.dataaccess.Auth;

import java.util.HashMap;

public class AuthController {
    private static final HashMap<String, boolean[]> permissions = new HashMap<>(){
        //endPoint: [AdminPermission, LiberianPermission]
        {
            put("addNewBook", new boolean[]{true, false});
            put("addNewMember", new boolean[]{true, false});
            put("addNewAuthor", new boolean[]{true, false});
            put("addNewCheckoutRecord", new boolean[]{false, true});
        }
    };

    static void checkPermission(String endPoint) throws AuthException {
        if(permissions.containsKey(endPoint)){
            if(SystemController.currentAuth == null){
                throw new AuthException("401 - Unauthorized");
            }
            if(SystemController.currentAuth == Auth.BOTH){return;}
            int index = SystemController.currentAuth == Auth.ADMIN ? 0 : 1;
            boolean[] permission = permissions.get(endPoint);
            if(!permission[index]){
                throw new AuthException("403 - Forbidden resource");
            }
        }
    }
}
