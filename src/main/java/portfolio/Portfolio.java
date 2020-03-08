package portfolio;

import portfolio.investments.Investment;

import java.util.HashSet;
import java.util.Set;

public class Portfolio<T extends Investment> {
    //TODO Complete this implementation and make it generic
    private Set<T> investments = new HashSet<>();

    public boolean contains(T investment) {
        return investments.contains(investment);
    }

    public void buy(T investment) {
        if (contains(investment)) {
            T inv = findInvestment(investment);
            inv.setCount(inv.getCount() + 1);
        } else {
            investments.add(investment);
        }
    }

    public void sell(String investment, int count) {
        T inv = findInvestmentByTitle(investment);
        if (contains(inv)) {
            inv.setCount(inv.getCount() - count);
            if (inv.getCount() == 0) {
                investments.remove(inv);
            }
        }
    }

    public T getShare(String title) {
        return findInvestmentByTitle(title);
    }

    //PRIVATE HELPING METHODS
    private T findInvestment(T investment) {
        for (T inv : investments) {
            if (inv.equals(investment)) {
                return inv;
            }
        }
        return null;
    }

    private T findInvestmentByTitle(String title) {
        for (T inv : investments) {
            if (inv.getTitel().equals(title)) {
                return inv;
            }
        }
        return null;
    }
}
