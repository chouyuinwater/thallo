package com.fish.design.model.behavior.strategy;

/**
 * 策略枚举
 *
 * 客户端调用的枚举后对应一个策略枚举
 * 客户端代用枚举方法直接转而调用策略枚举的方法
 */
public enum StrategyEnum {

    SUNDAY(Week.WEEKEND),
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY(Week.WEEKEND);

    private Week week;

    StrategyEnum() {
        this.week = Week.WEEKDAY;
    }

    StrategyEnum(Week week) {
        this.week = week;
    }



    private enum Week {
        WEEKEND {
            @Override
            double wages(int hour, double price) {
                return hour * 3 * price;
            }
        },
        WEEKDAY {
            @Override
            double wages(int hour, double price) {
                return (hour - 8) * price;
            }
        };

        abstract double wages(int hour,double price);
    }

    public double getMoney(int hour,double price) {
        return this.week.wages(hour, price);
    }
}
