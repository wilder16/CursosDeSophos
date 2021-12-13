package com.sophossolutions.tasks;

import com.sophossolutions.constants.ApiConstants;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ExeceutionGetToken implements Task {

    private String endpoint;
    private String id;

    public ExeceutionGetToken(String endpoint, String id){
        this.endpoint = endpoint;
        this.id = id;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(endpoint.concat(id)).with(
                request -> request.auth().oauth2(ApiConstants.TOKEN)
        ));
        SerenityRest.lastResponse().prettyPeek();
    }

    public static ExeceutionGetToken getInformation(String endpoint, String id){
        return Tasks.instrumented(ExeceutionGetToken.class, endpoint, id);
    }
}
