package com.sigar.Quiz.App.sessions;

import com.sigar.Quiz.App.model.AnswerDetails;
import com.sigar.Quiz.App.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SessionManager {
    public static Logger logger = LoggerFactory.getLogger(SessionManager.class);
    public final Map<Long,Session> userSessions = new ConcurrentHashMap<>();
    public final Map<Long,Session> sessionIdMap = new ConcurrentHashMap<>();

    public Session createSession(UserDTO userDTO){
        Long userId = userDTO.userId();
        if(!userSessions.containsKey(userId)){
            Long sessionId = Math.abs(UUID.randomUUID().getMostSignificantBits());
            Session newSession =  new Session(sessionId,userId,new HashMap(),new HashSet<>());
            userSessions.put(userId,newSession);
            sessionIdMap.put(sessionId,newSession);
            logger.info("New session created for user " + userId + " with sessionId : " + sessionId);
        }
        return userSessions.get(userId);
    }
    public Session getSessionByUserId(Long userId){
        return userSessions.get(userId);
    }
    public Session getSessionBySessionId(Long sessionId){
        return sessionIdMap.get(sessionId);
    }
    public boolean isvalidSession(Long sessionId, Long userId){
        return sessionId != null && userId != null &&
                userSessions.containsKey(userId) &&
                userSessions.get(userId).getSessionId().equals(sessionId);
    }

    public List<AnswerDetails> getSessionResults(Long sessionId){
        Session session = getSessionBySessionId(sessionId);
        if(session == null) return  Collections.emptyList();
        return session.getResults();
    }
    public void updateSessionResults(Long sessionId,AnswerDetails answerDetails){
        Session session = getSessionBySessionId(sessionId);
        if(session != null) session.updateResults(answerDetails);
    }
}
