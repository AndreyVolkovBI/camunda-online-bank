package tech.volkov.onlinebank.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import tech.volkov.onlinebank.global.GlobalConst;

@Component
public class KycDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) {
        String name = (String) delegateExecution.getVariable(GlobalConst.NAME_FIELD);
        int age = (int) delegateExecution.getVariable(GlobalConst.AGE_FIELD);
        int moneyLeft = (int) delegateExecution.getVariable(GlobalConst.MONEY_FIELD);

        boolean isKycFailed = false;

        if (name.equals("Ivan")) {
            isKycFailed = true;
        }

        delegateExecution.setVariable(GlobalConst.NAME_FIELD, name);
        delegateExecution.setVariable(GlobalConst.AGE_FIELD, age);
        delegateExecution.setVariable(GlobalConst.MONEY_FIELD, moneyLeft);
        delegateExecution.setVariable(GlobalConst.IS_KYC_FAILED_FIELD, isKycFailed);
    }
}
