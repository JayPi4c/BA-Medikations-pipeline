package com.jaypi4c.ba.pipeline.medicationplan.openehr;


import com.jaypi4c.ba.pipeline.medicationplan.openehr.compositions.nephromedikationcomposition.NephroMedikationComposition;
import com.jaypi4c.ba.pipeline.medicationplan.openehr.compositions.nephromedikationcomposition.NephroMedikationCompositionFactory;

import com.nedap.archie.rm.datavalues.DvText;
import com.nedap.archie.rm.ehr.EhrStatus;
import com.nedap.archie.rm.generic.PartySelf;
import com.nedap.archie.rm.support.identification.GenericId;
import com.nedap.archie.rm.support.identification.PartyRef;
import lombok.extern.slf4j.Slf4j;
import org.ehrbase.client.openehrclient.CompositionEndpoint;
import org.ehrbase.client.openehrclient.EhrEndpoint;
import org.ehrbase.client.openehrclient.OpenEhrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class OpenEhrManager {

    // see https://ehrbase.readthedocs.io/en/latest/02_getting_started/04_create_ehr/index.html#client-library
    private final OpenEhrClient openEhrClient;
    private final EhrEndpoint ehrEndpoint;
    private final NephroMedikationCompositionFactory nephroMedikationCompositionFactory;

    /**
     * the ID for the Arztbrief on application level
     */
    private UUID applicationUserID;
    /**
     * The ID for the EHR returned from EHRBase
     */
    private UUID ehrID;


    @Autowired
    public OpenEhrManager(OpenEhrClient openEhrClient, NephroMedikationCompositionFactory factory) {
        this.openEhrClient = openEhrClient;
        this.ehrEndpoint = openEhrClient.ehrEndpoint();

        nephroMedikationCompositionFactory = factory;
    }

    public void updateIDs() {
        applicationUserID = UUID.randomUUID();
        ehrID = ehrEndpoint.createEhr(createEhrStatus(applicationUserID));
    }

    public boolean sendNephroMedikationData(String[][] medicationMatrix) {
        if (applicationUserID == null || ehrID == null) {
            updateIDs();
        }
        NephroMedikationComposition composition = nephroMedikationCompositionFactory.createComposition(medicationMatrix);

        CompositionEndpoint compositionEndpoint = openEhrClient.compositionEndpoint(ehrID);
        compositionEndpoint.mergeCompositionEntity(composition);
        return true;
    }

    private EhrStatus createEhrStatus(UUID applicationUserID) {
        EhrStatus status = new EhrStatus();
        status.setArchetypeNodeId("openEHR-EHR-ITEM_TREE.generic.v1");

        DvText name = new DvText();
        name.setValue("any EHR STATUS");
        status.setName(name);

        PartySelf subject = new PartySelf();
        PartyRef externalRef = new PartyRef();
        GenericId id = new GenericId();
        id.setValue(applicationUserID.toString());
        id.setScheme("id_scheme");
        externalRef.setId(id);
        externalRef.setNamespace("BA");
        externalRef.setType("PERSON");
        subject.setExternalRef(externalRef);
        status.setSubject(subject);

        status.setModifiable(true);
        status.setQueryable(true);

        return status;
    }


}