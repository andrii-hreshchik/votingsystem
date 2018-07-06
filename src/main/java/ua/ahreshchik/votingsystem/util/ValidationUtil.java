package ua.ahreshchik.votingsystem.util;

import ua.ahreshchik.votingsystem.HasId;
import ua.ahreshchik.votingsystem.util.exception.IllegalRequestDataException;

public class ValidationUtil {
    public static void checkNew(HasId bean) {
        if (!bean.isNew()) {
            throw new IllegalRequestDataException(bean + " must be new (id=null)");
        }
    }
}
