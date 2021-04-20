package resources;

import java.util.List;

public class Resources {
    private String url;
    private String chromeDriver;
    private List<RepaymentCalculator> repaymentCalculator;
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getChromeDriver() {
        return chromeDriver;
    }

    public void setChromeDriver(String chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    public List<RepaymentCalculator> getRepaymentCalculator() {
        return repaymentCalculator;
    }

    public void setRepaymentCalculator(List<RepaymentCalculator> repaymentCalculator) {
        this.repaymentCalculator = repaymentCalculator;
    }



    public static class RepaymentCalculator{
        private String amount;
        private String over;
        private String repaymentType;

        public String getRepaymentAmt() {
            return repaymentAmt;
        }

        public void setRepaymentAmt(String repaymentAmt) {
            this.repaymentAmt = repaymentAmt;
        }

        public String getInterestAmt() {
            return interestAmt;
        }

        public void setInterestAmt(String interestAmt) {
            this.interestAmt = interestAmt;
        }

        private String repaymentAmt;
        private String interestAmt;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getOver() {
            return over;
        }

        public void setOver(String over) {
            this.over = over;
        }

        public String getRepaymentType() {
            return repaymentType;
        }

        public void setRepaymentType(String repaymentType) {
            this.repaymentType = repaymentType;
        }
    }

}
