package com.example.jutao.strategymodel.Strategy;

import com.example.jutao.strategymodel.CashNormal;
import com.example.jutao.strategymodel.CashRebate;
import com.example.jutao.strategymodel.CashReturn;
import com.example.jutao.strategymodel.Factor.CashSuper;

public class CashContext {
  private CashSuper cs;

  public CashContext(int type) {
    switch (type) {
      case 0:
        cs=new CashNormal();
        break;
      case 1:
        cs=new CashReturn(300,100);
        break;
      case 2:
        cs = new CashRebate(0.8);
        break;
      case 3:
        cs = new CashRebate(0.7);
        break;
      case 4:
        cs = new CashRebate(0.5);
        break;
    }
  }

  public double GetResule(double money) {
    return cs.acceptCash(money);
  }
}
