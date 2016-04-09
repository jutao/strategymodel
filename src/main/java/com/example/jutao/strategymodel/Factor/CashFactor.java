package com.example.jutao.strategymodel.Factor;

import com.example.jutao.strategymodel.CashNormal;
import com.example.jutao.strategymodel.CashRebate;
import com.example.jutao.strategymodel.CashReturn;

/**
 * 现金收费工厂类
 */
public class CashFactor {
  public static CashSuper createCashAccept(int type) {
    CashSuper cs = null;
    switch (type) {
      case 0:
        cs = new CashNormal();
        break;
      case 1:
        cs = new CashReturn(300, 100);
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
    return cs;
  }
}
