package discuss.Services;

import discuss.domain.Beekeeper;

/**
 * Created by student on 2015/09/23.
 */
public interface BeekeeperService {
    String saveBeekeeper(String firstName,
                        String lastName,
                        String Email,
                        String LocationName,
                        String SubLocationName,
                        String HiveState,
                        String SuperState
    );

    Beekeeper getBeekeeper(Long id);
}
