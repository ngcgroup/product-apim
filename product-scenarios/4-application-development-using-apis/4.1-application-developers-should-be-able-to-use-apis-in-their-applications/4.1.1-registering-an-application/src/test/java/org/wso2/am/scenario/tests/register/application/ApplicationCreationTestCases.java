/*
 *Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *WSO2 Inc. licenses this file to you under the Apache License,
 *Version 2.0 (the "License"); you may not use this file except
 *in compliance with the License.
 *You may obtain a copy of the License at
 *
 *http://www.apache.org/licenses/LICENSE-2.0
 *
 *Unless required by applicable law or agreed to in writing,
 *software distributed under the License is distributed on an
 *"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *KIND, either express or implied.  See the License for the
 *specific language governing permissions and limitations
 *under the License.
 */

package org.wso2.am.scenario.tests.register.application;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.am.integration.test.utils.APIManagerIntegrationTestException;
import org.wso2.am.integration.test.utils.base.APIMIntegrationConstants;
import org.wso2.am.integration.test.utils.bean.APPKeyRequestGenerator;
import org.wso2.am.scenario.test.common.APIStoreRestClient;
import org.wso2.am.scenario.test.common.ScenarioTestBase;
import org.wso2.carbon.automation.test.utils.http.client.HttpResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class ApplicationCreationTestCases extends ScenarioTestBase {
    private APIStoreRestClient apiStore;
    private List<String> applicationsList = new ArrayList<>();
    private static final String ADMIN_LOGIN_USERNAME = "admin";
    private static final String ADMIN_LOGIN_PW = "admin";
    private static final String DEFAULT_STORE_URL = "https://localhost:9443/store";
    private static final String UTF_8 = "UTF-8";
    private static final String ERROR_APPLICATION_CREATION_FAILED = "Application creation failed for application: ";
    private static final String ERROR_APPLICATION_CREATION_WITH_VALID_INPUT = "Application creation with valid " +
            "input failed for application: ";
    private static final String ERROR_APPLICATION_TIER_MISMATCH = "Application tier value mismatch for application: ";
    private static final String ERROR_APPLICATION_DESCRIPTION_MISMATCH = "Application description value mismatch" +
            " for application: ";
    private static final String ERROR_APPLICATION_TOKEN_TYPE_MISMATCH = "Application token type value mismatch" +
            " for application: ";
    private static final String ERROR_GENERATING_KEY = " key generation failed for application:  ";
    private static final String ERROR = "error";
    private static final String STATUS = "status";
    private static final String STATUS_APPROVED = "APPROVED";
    private static final String NAME = "name";
    private static final String TIER = "tier";
    private static final String DESCRIPTION = "description";
    private static final String TOKEN_TYPE = "tokenType";
    private static final String APPLICATIONS = "applications";
    private static final String DATA = "data";
    private static final String KEY = "key";
    private static final String KEY_STATE = "keyState";
    private static final String APP_DETAILS = "appDetails";
    private static final String KEY_TYPE = "key_type";
    private static final String PRODUCTION = "PRODUCTION";
    private static final String SANDBOX = "SANDBOX";
    private static final String APPLICATION_KEY_GENERATION = "ApplicationKeyGeneration";
    private static final String APPLICATION_DESCRIPTION = "ApplicationDescription";

    @BeforeClass(alwaysRun = true)
    public void init() throws APIManagerIntegrationTestException {
        String storeURL;
        Properties infraProperties;

        infraProperties = getDeploymentProperties();
        storeURL = infraProperties.getProperty(STORE_URL);
        if (storeURL == null) {
            storeURL = DEFAULT_STORE_URL;
        }
        setKeyStoreProperties();
        apiStore = new APIStoreRestClient(storeURL);
        apiStore.login(ADMIN_LOGIN_USERNAME, ADMIN_LOGIN_PW);
    }

    @Test(description = "4.1.1.1")
    public void testApplicationCreationWithMixCaseAlphabetName() throws Exception {
        String applicationName = "Application";
        String tier = APIMIntegrationConstants.APPLICATION_TIER.UNLIMITED;
        String description = "NewAppDescription";

        HttpResponse addApplicationResponse = apiStore.addApplication(applicationName, tier,
                "", description);
        applicationsList.add(applicationName);
        verifyResponse(addApplicationResponse);
        assertEquals(new JSONObject(addApplicationResponse.getData()).get(STATUS), STATUS_APPROVED,
                ERROR_APPLICATION_CREATION_WITH_VALID_INPUT + applicationName);
        validateApplicationWithValidMandatoryValues(applicationName, tier, description);
    }

    @Test(description = "4.1.1.1")
    public void testApplicationCreationWithSpecialCharacterName() throws Exception {
        String applicationName = "Application_-.";
        String tier = APIMIntegrationConstants.APPLICATION_TIER.UNLIMITED;
        String description = "NewAppDescription";

        HttpResponse addApplicationResponse = apiStore.addApplication(applicationName, tier,
                "", description);
        applicationsList.add(applicationName);
        verifyResponse(addApplicationResponse);
        assertEquals(new JSONObject(addApplicationResponse.getData()).get(STATUS), STATUS_APPROVED,
                ERROR_APPLICATION_CREATION_WITH_VALID_INPUT + applicationName);
        validateApplicationWithValidMandatoryValues(applicationName, tier, description);
    }

    @Test(description = "4.1.1.1")
    public void testApplicationCreationWithNumericName() throws Exception {
        String applicationName = "1234";
        String tier = APIMIntegrationConstants.APPLICATION_TIER.UNLIMITED;
        String description = "";

        HttpResponse addApplicationResponse = apiStore.addApplication(applicationName, tier,
                "", description);
        applicationsList.add(applicationName);
        verifyResponse(addApplicationResponse);
        assertEquals(new JSONObject(addApplicationResponse.getData()).get(STATUS), STATUS_APPROVED,
                ERROR_APPLICATION_CREATION_WITH_VALID_INPUT + applicationName);
        validateApplicationWithValidMandatoryValues(applicationName, tier, description);
    }

    private void validateApplicationWithValidMandatoryValues(String applicationName, String tier, String description)
            throws Exception {
        HttpResponse getAllAppResponse = apiStore.getAllApplications();
        verifyResponse(getAllAppResponse);
        JSONArray getAllAppJsonArray = new JSONObject(getAllAppResponse.getData()).getJSONArray(APPLICATIONS);

        for (int i = 0; i < getAllAppJsonArray.length(); i++) {
            if (applicationName.equals(getAllAppJsonArray.getJSONObject(i).getString(NAME))) {
                assertEquals(getAllAppJsonArray.getJSONObject(i).getString(TIER), tier,
                        ERROR_APPLICATION_TIER_MISMATCH + applicationName);
                assertEquals(getAllAppJsonArray.getJSONObject(i).getString(DESCRIPTION), description,
                        ERROR_APPLICATION_DESCRIPTION_MISMATCH + applicationName);
            }
        }
    }

    @Test(description = "4.1.1.2")
    public void testApplicationCreationWithDefaultTokenType() throws Exception {
        String applicationName = "AppToken1";
        String tier = APIMIntegrationConstants.APPLICATION_TIER.UNLIMITED;
        String description = "";
        String tokenType = "DEFAULT";

        HttpResponse addApplicationResponse = apiStore.addApplicationWithTokenType(applicationName, tier,
                "", description,tokenType);
        applicationsList.add(applicationName);
        verifyResponse(addApplicationResponse);
        assertEquals(new JSONObject(addApplicationResponse.getData()).get(STATUS), STATUS_APPROVED,
                ERROR_APPLICATION_CREATION_WITH_VALID_INPUT + applicationName);
        validateApplicationWithMandatoryAndOptionsValues(applicationName, tier, description, tokenType);
    }

    @Test(description = "4.1.1.2")
    public void testApplicationCreationWithJWTTokenType() throws Exception {
        String applicationName = "AppToken2";
        String tier = APIMIntegrationConstants.APPLICATION_TIER.UNLIMITED;
        String description = "";
        String tokenType = "JWT";

        HttpResponse addApplicationResponse = apiStore.addApplicationWithTokenType(applicationName,
                tier, "", description, tokenType);
        applicationsList.add(applicationName);
        verifyResponse(addApplicationResponse);
        assertEquals(new JSONObject(addApplicationResponse.getData()).get(STATUS), STATUS_APPROVED,
                ERROR_APPLICATION_CREATION_WITH_VALID_INPUT + applicationName);
        validateApplicationWithMandatoryAndOptionsValues(applicationName, tier, description, tokenType);
    }

    @Test(description = "4.1.1.2")
    public void testApplicationCreationWithOAuthTokenType() throws Exception {
        String applicationName = "AppToken3";
        String tier = APIMIntegrationConstants.APPLICATION_TIER.UNLIMITED;
        String description = "";
        String tokenType = "OAuth";

        HttpResponse addApplicationResponse = apiStore
                .addApplicationWithTokenType(applicationName, tier, "",description, tokenType);
        applicationsList.add(applicationName);
        verifyResponse(addApplicationResponse);
        assertEquals(new JSONObject(addApplicationResponse.getData()).get(STATUS), STATUS_APPROVED,
                ERROR_APPLICATION_CREATION_WITH_VALID_INPUT + applicationName);
        validateApplicationWithMandatoryAndOptionsValues(applicationName, tier, description, tokenType);
    }

    private void validateApplicationWithMandatoryAndOptionsValues(String applicationName, String tier,
                                                                 String description, String tokenType)
            throws Exception {
        HttpResponse getAllAppResponse = apiStore.getAllApplications();
        verifyResponse(getAllAppResponse);
        JSONArray getAllAppJsonArray = new JSONObject(getAllAppResponse.getData()).getJSONArray(APPLICATIONS);

        for (int i = 0; i < getAllAppJsonArray.length(); i++) {
            if (applicationName.equals(getAllAppJsonArray.getJSONObject(i).getString(NAME))) {
                assertEquals(getAllAppJsonArray.getJSONObject(i).getString(TIER), tier,
                        ERROR_APPLICATION_TIER_MISMATCH + applicationName);
                assertEquals(getAllAppJsonArray.getJSONObject(i).getString(DESCRIPTION), description,
                        ERROR_APPLICATION_DESCRIPTION_MISMATCH + applicationName);
                assertEquals(getAllAppJsonArray.getJSONObject(i).getString(TOKEN_TYPE), tokenType,
                        ERROR_APPLICATION_TOKEN_TYPE_MISMATCH + applicationName);
            }
        }
    }

    @Test
    private void testCreateApplicationForKeyGeneration() throws Exception {
        HttpResponse addApplicationResponse = apiStore
                .addApplication(APPLICATION_KEY_GENERATION,APIMIntegrationConstants.APPLICATION_TIER.UNLIMITED,
                        "", APPLICATION_DESCRIPTION);
        applicationsList.add(APPLICATION_KEY_GENERATION);
        verifyResponse(addApplicationResponse);
        assertEquals(new JSONObject(addApplicationResponse.getData()).get(STATUS), STATUS_APPROVED,
                ERROR_APPLICATION_CREATION_FAILED + APPLICATION_KEY_GENERATION);
    }

    @Test(description = "4.1.1.3", dependsOnMethods = {"testCreateApplicationForKeyGeneration"})
    public void testGenerateProductionKeysForApplication() throws Exception {
        APPKeyRequestGenerator appKeyRequestGenerator = new APPKeyRequestGenerator(APPLICATION_KEY_GENERATION);
        verifyKeyGeneration(apiStore.generateApplicationKey(appKeyRequestGenerator).getData(), PRODUCTION);
    }

    @Test(description = "4.1.1.4", dependsOnMethods = {"testCreateApplicationForKeyGeneration"})
    public void testGenerateSandboxKeysForApplication() throws Exception {
        APPKeyRequestGenerator appKeyRequestGenerator = new APPKeyRequestGenerator(APPLICATION_KEY_GENERATION);
        appKeyRequestGenerator.setKeyType(SANDBOX);
        verifyKeyGeneration(apiStore.generateApplicationKey(appKeyRequestGenerator).getData(), SANDBOX);
    }

    private void verifyKeyGeneration(String responseString, String keyType) {
        JSONObject responseStringJson = new JSONObject(responseString);
        assertFalse(responseStringJson.getBoolean(ERROR),
                keyType + ERROR_GENERATING_KEY + APPLICATION_KEY_GENERATION);
        assertEquals(responseStringJson.getJSONObject(DATA).getJSONObject(KEY).getString(KEY_STATE), STATUS_APPROVED,
                keyType + ERROR_GENERATING_KEY + APPLICATION_KEY_GENERATION);
        assertEquals(new JSONObject(responseStringJson.getJSONObject(DATA).getJSONObject(KEY).getString(APP_DETAILS))
                .get(KEY_TYPE), keyType, keyType + ERROR_GENERATING_KEY + APPLICATION_KEY_GENERATION);
    }

    @AfterClass(alwaysRun = true)
    public void destroy() throws Exception {
        for (String name : applicationsList) {
            apiStore.removeApplication(name);
        }
        applicationsList.clear();
    }
}