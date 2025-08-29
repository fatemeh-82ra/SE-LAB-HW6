package com.energy.management.main;

import com.energy.management.context.BuildingEnergyContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BuildingEnergyContext context = new BuildingEnergyContext();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("سیستم مدیریت انرژی ساختمان شروع شد.");
        System.out.println("وضعیت اولیه: Active, تعرفه: Standard");

        while (running) {
            System.out.println("\nمنوی سیستم مدیریت انرژی ساختمان:");
            System.out.println("1. تغییر وضعیت سیستم (مدیر)");
            System.out.println("2. تغییر سیاست محاسبه هزینه (مدیر)");
            System.out.println("3. مشاهده وضعیت فعلی سیستم");
            System.out.println("4. شبیه‌سازی مصرف انرژی و محاسبه هزینه");
            System.out.println("5. خروج");
            System.out.print("گزینه مورد نظر را وارد کنید: ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("ورودی نامعتبر! لطفاً یک عدد وارد کنید.");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("وضعیت‌های ممکن: 1. Active, 2. Eco Mode, 3. Shutdown");
                    System.out.print("وضعیت جدید را انتخاب کنید: ");
                    int stateChoice;
                    try {
                        stateChoice = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("ورودی نامعتبر! لطفاً یک عدد وارد کنید.");
                        scanner.nextLine();
                        continue;
                    }
                    scanner.nextLine();
                    if (stateChoice == 1) {
                        context.changeState("Active");
                    } else if (stateChoice == 2) {
                        context.changeState("Eco Mode");
                    } else if (stateChoice == 3) {
                        context.changeState("Shutdown");
                    } else {
                        System.out.println("گزینه نامعتبر!");
                    }
                    break;

                case 2:
                    System.out.println("سیاست‌های ممکن: 1. Standard, 2. Peak Hours, 3. Green Mode");
                    System.out.print("سیاست جدید را انتخاب کنید: ");
                    int strategyChoice;
                    try {
                        strategyChoice = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("ورودی نامعتبر! لطفاً یک عدد وارد کنید.");
                        scanner.nextLine();
                        continue;
                    }
                    scanner.nextLine();
                    if (strategyChoice == 1) {
                        context.setCostStrategy("Standard");
                    } else if (strategyChoice == 2) {
                        context.setCostStrategy("Peak Hours");
                    } else if (strategyChoice == 3) {
                        context.setCostStrategy("Green Mode");
                    } else {
                        System.out.println("گزینه نامعتبر!");
                    }
                    break;

                case 3:
                    System.out.println(context.getStatus());
                    break;

                case 4:
                    System.out.print("میزان مصرف انرژی (واحد) را وارد کنید: ");
                    int units;
                    try {
                        units = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("ورودی نامعتبر! لطفاً یک عدد وارد کنید.");
                        scanner.nextLine();
                        continue;
                    }
                    scanner.nextLine();
                    if (units < 0) {
                        System.out.println("مقدار مصرف نمی‌تواند منفی باشد!");
                    } else {
                        double cost = context.simulateCost(units);
                        System.out.println("هزینه برای " + units + " واحد: " + cost + " تومان");
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("خروج از برنامه...");
                    break;

                default:
                    System.out.println("گزینه نامعتبر!");
            }
        }
        scanner.close();
    }
}