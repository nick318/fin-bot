package org.finbot;

import java.util.Map;

public interface UserSessionContext {
    Map<String, Object> paramsByUser();
}
