package Lesson4;

import Lesson4.Exception.BlockDepositException;

public class PinValidator {
    private long timeBlockCount;
    private int counterInputPinCode;

    public PinValidator(){
        this.counterInputPinCode = 0;
        this.timeBlockCount = 0 ;
    }

    public long getTimeBlockCount(){
        return timeBlockCount;
    }

    public int getCounterInputPinCode() {
        return counterInputPinCode;
    }

    public boolean comparePinCode(int pinCode, TerminalServer server, Person person) throws Exception{
          if (server.comparePinCode(person, pinCode)){
              counterInputPinCode = 0;
              return true;
          }
          else {
              if (counterInputPinCode == 3){
                  server.blockDeposit(person);
                  throw new BlockDepositException();
              }
              else{
                  counterInputPinCode++;
                  return false;
              }
          }
    }
}
