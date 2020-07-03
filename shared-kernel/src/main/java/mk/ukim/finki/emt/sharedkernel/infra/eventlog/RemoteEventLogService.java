package mk.ukim.finki.emt.sharedkernel.infra.eventlog;

import mk.ukim.finki.emt.sharedkernel.domain.base.RemoteEventLog;
import org.springframework.stereotype.Service;

@Service
public interface RemoteEventLogService {

    String source();

    RemoteEventLog currentLog(long lastProcessedId);

}
