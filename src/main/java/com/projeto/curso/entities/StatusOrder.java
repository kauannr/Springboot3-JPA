package com.projeto.curso.entities;

public enum StatusOrder {
    WATING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private StatusOrder(int code) {
        this.code = code;
    }

    public int getcode() {
        return code;
    }

    public static StatusOrder valueOf(int code){
        for (StatusOrder statusOrder : StatusOrder.values()) {
            
            if (code == statusOrder.getcode()) {
                return statusOrder;
            }else{
                throw new IllegalArgumentException("Código inválido");
            }
        }
        return null;
    }
}
