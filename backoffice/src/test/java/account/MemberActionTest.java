package account;

import com.han.onlystore.backoffice.Application;
import com.han.onlystore.backoffice.action.account.MemberAction;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by apple on 2017/2/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class MemberActionTest {
    @Autowired
    private MemberAction memberAction;

}
