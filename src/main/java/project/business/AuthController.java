package project.business;

import project.dataaccess.Auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;

public class AuthController {
    private static final HashMap<Endpoints, boolean[]> permissions = new HashMap<>(){
        //endPoint: [AdminPermission, LiberianPermission]
        {
            put(Endpoints.addNewBook, new boolean[]{true, false});
            put(Endpoints.updateBook, new boolean[]{true, true});
            put(Endpoints.addNewMember, new boolean[]{true, false});
            put(Endpoints.addNewAuthor, new boolean[]{true, false});
            put(Endpoints.addNewCheckoutRecord, new boolean[]{false, true});
        }
    };

    static void checkPermission(Endpoints endPoint) throws AuthException {
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
