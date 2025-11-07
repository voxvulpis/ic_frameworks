package br.unesp;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Application {
    public static void main(String[] args) {
        System.out.println("[DEBUG] -------------------- Launching Main --------------------");
        Quarkus.run(args);
    }
}
