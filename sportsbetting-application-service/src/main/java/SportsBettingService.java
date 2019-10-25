import java.math.BigDecimal;
import java.util.List;

import com.example.sportsbetting.dao.*;
import com.example.sportsbetting.domain.OutcomeOdd;
import com.example.sportsbetting.domain.Player;
import com.example.sportsbetting.domain.SportEvent;
import com.example.sportsbetting.domain.Wager;

import interfaces.ISportsBettingService;

import org.springframework.beans.factory.annotation.Autowired;


public class SportsBettingService implements ISportsBettingService {

    @Autowired
    private ISportEventDao sportEventDao;

    @Autowired
    private IWagerDao wagerDao;

    @Autowired
    private IPlayerDao playerDao;

    @Autowired
    private IOutComeOddDao outcomeOddDao;

    public SportsBettingService() {
    }

    @Override
    public void savePlayer(Player player) {
        this.playerDao.AddPlayer(player);
    }

    @Override
    public Player findPlayer() {
        return this.playerDao.GetActualPlayer();
    }

    @Override
    public List<SportEvent> findAllSportEvents() {
        return this.sportEventDao.GetAllSportEvent();
    }

    @Override
    public void saveWage(Wager wager) {
        this.wagerDao.InsertWager(wager);
    }

    @Override
    public List<Wager> findAllWagers() {
        return this.wagerDao.GetWager();
    }

    @Override
    public void calculateResults() {
        List<Wager> wagerList = this.wagerDao.GetWager();
        Player player = this.playerDao.GetActualPlayer();
        for (Wager wager : wagerList) {
            if (wager.isWin()) {
                BigDecimal val = wager.getOdd().getValue().multiply(wager.getAmount());
                BigDecimal newBalance = player.getBalance().add(val);
                
                // Update local resource
                player.setBalance(newBalance);
                
                //Update in database
                this.playerDao.UpdatePlayerBalance(newBalance);
            }
        }
    }

    @Override
    public void InsertOutcomeOdd(OutcomeOdd odd) {
        this.outcomeOddDao.InsertOutcomeOdd(odd);
    }

    public void updatePlayerBalance(BigDecimal newVal) {
        this.playerDao.UpdatePlayerBalance(newVal);
    }
}
