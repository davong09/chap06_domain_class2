package com.javalab.cafe.excute;

import com.javalab.cafe.data.ArrayListDatabase;
import com.javalab.cafe.domain.Category;
import com.javalab.cafe.domain.Employee;
import com.javalab.cafe.domain.Order;
import com.javalab.cafe.domain.Product;

import java.util.ArrayList;
import java.util.EnumMap;

/**
 * 카페 관리 시스템
 * - ArrayListDatabase 클래스를 이용한 카페 관리 시스템
 * - 주문, 사원, 상품, 카테고리 정보를 ArrayList에 저장하고 관리
 * - 데이터 전담 클래스를 만들어서 기초 데이터 생성 작업
 */


public class CafeManagementArrayList {
    public static void main(String[] args) {
        // ArrayList 형태로 된 데이터베이스 객체 생성
        ArrayListDatabase db = new ArrayListDatabase();

        // 카테고리 ArrayList 객체 얻기 - 카테고리 정보 출력
        ArrayList<Category> categories = db.getCategoryList();
        showCategorylist(categories);

        // 상품 Arraylist 객체 얻기 - 상품 정보 출력
        ArrayList<Product> products = db.getProductList();
        //showProductList(products);

        // 주문 ArrayList 객체 얻기 - 주문 정보 출력
        ArrayList<Order> orders = db.getOrderList();

        ArrayList<Employee> employees = db.getEmployeeList();
        showEmployeeList(employees);

        showProductsWiwhCategoryName(products, categories);
        showOrderList(orders);

        showOrderproemp(orders, products, employees);

    } // end

    // 상품 정보 출력
            // 사원 정보 출력
    public static void showEmployeeList(ArrayList<Employee> employees){
        System.out.println("사원 정보");
        System.out.println("사원번호\t 직원명\t 직급\t 급여");
        System.out.println("---------------------------");
        for(Employee e : employees){
            System.out.println(e.getEmployeeId() + "\t" + e.getName() + "\t" + e.getPosition() + "\t" + e.getSalary());
        }
    }
    private static void showProductsWiwhCategoryName(ArrayList<Product> products,
                                                     ArrayList<Category> categories) {
        System.out.println("상품 정보");
        System.out.println("상품번호\t상품명\t카테고리id\t가격");
        System.out.println("-------------------------------");
        for(Product product : products){
            int categoryId = product.getCategoryId(); // 현재 상품의 카테고리Id
            String categoryName = ""; // 카테고리 이름
            // for 문으로 카테고리 리스트에서 카테고리Id와 일치하는 카테고리 이름 찾기
            if(categoryId != 0){
                for(Category category : categories){    // 카테고리 for문
                    if(category.getCategoryId() == categoryId){
                        categoryName = category.getName();
                        break;
                    }
                }
            }
            System.out.println(product.getProductId() + "\t" + product.getProductname()
                    + "\t" + product.getCategoryId() + "\t" + categoryName + "\t" + product.getPrice());
        }
    }


    // 주문 정보 출력
    public static void showOrderList(ArrayList<Order> orders) {
        System.out.println("주문 정보");
        System.out.println("주문번호\t주문일자\t상품Id\t주문처리사원Id\t주문수량");
        System.out.println("-------------------------------");
        for(Order o : orders){
            System.out.println(o.getOrderId() + "\t" + o.getOrderDate() + "\t"
                    + o.getProductId() + "\t" + o.getEmployeeId() + "\t" + o.getQuantity());
        }
    }
    // 카테고리 정보 출력
    public static void showCategorylist(ArrayList<Category> categories){
        System.out.println("카테고리 정보");
        System.out.println("카테고리번호\t 카테고리명\t 설명");
        System.out.println("============================");
        for(Category c : categories){
            System.out.println(c.getCategoryId() + "\t" + c.getName() + "\t" + c.getDescription());
        }
    }

    // [과제] 주문 ArrayList에 상품명과 사원명이 나오도록 출력하기.
    public static void showOrderproemp(ArrayList<Order> orders, ArrayList<Product> products, ArrayList<Employee> employees) {
        System.out.println("[과제] 주문 ArrayList에 상품명과 사원명이 나오도록 출력하기");
        System.out.println("주문번호\t주문일자\t사원명\t상품명\t주문수량");
        System.out.println("===================================================");
        for(Order o : orders) {
            int ProductId = o.getProductId(); // 상품ID getProductId의 값을 ProductId에 넣음
            String ProductName = ""; // 상품명 넣는 변수
            if(ProductId != 0) {
                for(Product p : products) {
                    if(p.getProductId() == ProductId) {
                        ProductName = p.getProductname();
                        int EmployeeId = o.getEmployeeId();
                        String EmployeeName = ""; // 직원명 넣는 변수
                        if(EmployeeId != 0) {
                            for (Employee e : employees) {
                                if(EmployeeId == e.getEmployeeId()) {
                                    EmployeeName = e.getName();
                                    break;
                                }
                            }
                        }
                        System.out.println(o.getOrderId() + "\t" + o.getOrderDate() + "\t" +
                                EmployeeName + "\t" + ProductName + "\t" + o.getQuantity());
                    }
                }
            }
        }
    }
}
