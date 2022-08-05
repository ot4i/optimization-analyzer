/********************************************************* {COPYRIGHT-TOP} ***
* Copyright 2022 IBM Corporation
*
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the MIT License
* which accompanies this distribution
 ********************************************************** {COPYRIGHT-END} **/

package com.ibm.dev;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;

public class AnalyzeOptimizations {

	   @SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		   ArrayList<String> CLR = new ArrayList<String>();
		   ArrayList<String> Deploy = new ArrayList<String>();
		   ArrayList<String> JVM = new ArrayList<String>();
		   ArrayList<String> NodeJS = new ArrayList<String>();
		   ArrayList<String> Nodes_Dotnet = new ArrayList<String>();
		   ArrayList<String> Nodes_Aggregation = new ArrayList<String>();
		   ArrayList<String> Nodes_Basic = new ArrayList<String>();
		   ArrayList<String> Nodes_CallableFlow = new ArrayList<String>();
		   ArrayList<String> Nodes_Connector = new ArrayList<String>();
		   ArrayList<String> Nodes_ESQL = new ArrayList<String>();
		   ArrayList<String> Nodes_Group = new ArrayList<String>();
		   ArrayList<String> Nodes_JMSTransform = new ArrayList<String>();
		   ArrayList<String> Nodes_MQ = new ArrayList<String>();
		   ArrayList<String> Nodes_REST = new ArrayList<String>();
		   ArrayList<String> Nodes_SecurityPEP = new ArrayList<String>();
		   ArrayList<String> Nodes_Timer = new ArrayList<String>();		   
		   ArrayList<String> JavaNodes_Adapters = new ArrayList<String>();
		   ArrayList<String> JavaNodes_CICS = new ArrayList<String>();
		   ArrayList<String> JavaNodes_CORBA = new ArrayList<String>();
		   ArrayList<String> JavaNodes_Collection = new ArrayList<String>();
		   ArrayList<String> JavaNodes_Email = new ArrayList<String>();
		   ArrayList<String> JavaNodes_File = new ArrayList<String>();
		   ArrayList<String> JavaNodes_IMS = new ArrayList<String>();
		   ArrayList<String> JavaNodes_JDBC = new ArrayList<String>();
		   ArrayList<String> JavaNodes_JMS = new ArrayList<String>();
		   ArrayList<String> JavaNodes_JavaCompute = new ArrayList<String>();
		   ArrayList<String> JavaNodes_Kafka = new ArrayList<String>();
		   ArrayList<String> JavaNodes_MQTT = new ArrayList<String>();
		   ArrayList<String> JavaNodes_Mapping = new ArrayList<String>();
		   ArrayList<String> JavaNodes_ODM = new ArrayList<String>();
		   ArrayList<String> JavaNodes_TCPIP = new ArrayList<String>();
		   ArrayList<String> JavaNodes_WSRR = new ArrayList<String>();
		   ArrayList<String> JavaNodes_XSLT = new ArrayList<String>();
		   ArrayList<String> JavaScriptNodes_LoopBack = new ArrayList<String>();
		   ArrayList<String> JavaScriptNodes_Salesforce = new ArrayList<String>();			   
		   ArrayList<String> ResourceManagers_FTE = new ArrayList<String>();
		   ArrayList<String> ResourceManagers_GlobalCache = new ArrayList<String>();			   
		   ArrayList<String> FlowSecurityProviders_LDAP = new ArrayList<String>();
		   ArrayList<String> FlowSecurityProviders_TFIM = new ArrayList<String>();
		   ArrayList<String> FlowSecurityProviders_WS_Trust = new ArrayList<String>();
		   
		   
		    File currentdir = new File(System.getProperty("user.dir"));
	        File[] children = currentdir.listFiles();
	        for (File subdir : children) {
	            if (subdir.isDirectory()) {	            	
	            	File serverconfyaml = new File(subdir+ System.getProperty("file.separator") + "server.components.yaml");
	            	if (serverconfyaml.exists()) { 
	            		System.out.println("Analyzing the server.conf.yaml for " + subdir.getName() + ": " + serverconfyaml.getAbsolutePath());
	            		Yaml yaml = new Yaml();
	            		InputStream inputStream;
	            		try {
	        			   inputStream = new FileInputStream(serverconfyaml);		
	        			   Map<String, Object> obj = yaml.load(inputStream);
	        			   
	        			   // Record matches for CLR, Deploy, JVM, NodeJS
	        			   if (obj.get("CLR").equals(true)) {CLR.add(subdir.getName());}
	        			   if (obj.get("Deploy").equals(true)) {Deploy.add(subdir.getName());}
	        			   if (obj.get("JVM").equals(true)) {JVM.add(subdir.getName());}
	        			   if (obj.get("NodeJS").equals(true)) {NodeJS.add(subdir.getName());}
	        			   
	        			   // Record matches for Nodes
	        			   Map<String, Object> NodesObject = (Map<String, Object>) obj.get("Nodes");
	        			   if (NodesObject.get(".NET").equals(true)) {Nodes_Dotnet.add(subdir.getName());}	        			   
	        			   if (NodesObject.get("Aggregation").equals(true)) {Nodes_Aggregation.add(subdir.getName());}
	        			   if (NodesObject.get("Basic").equals(true)) {Nodes_Basic.add(subdir.getName());}
	        			   if (NodesObject.get("CallableFlow").equals(true)) {Nodes_CallableFlow.add(subdir.getName());}
	        			   if (NodesObject.get("Connector").equals(true)) {Nodes_Connector.add(subdir.getName());}
	        			   if (NodesObject.get("ESQL").equals(true)) {Nodes_ESQL.add(subdir.getName());}
	        			   if (NodesObject.get("Group").equals(true)) {Nodes_Group.add(subdir.getName());}
	        			   if (NodesObject.get("JMSTransform").equals(true)) {Nodes_JMSTransform.add(subdir.getName());}
	        			   if (NodesObject.get("MQ").equals(true)) {Nodes_MQ.add(subdir.getName());}
	        			   if (NodesObject.get("REST").equals(true)) {Nodes_REST.add(subdir.getName());}
	        			   if (NodesObject.get("SecurityPEP").equals(true)) {Nodes_SecurityPEP.add(subdir.getName());}
	        			   if (NodesObject.get("Timer").equals(true)) {Nodes_Timer.add(subdir.getName());}		   

	        			   // Record matches for JavaNodes	        			   
	        			   Map<String, Object> JavaNodesObject = (Map<String, Object>) obj.get("JavaNodes");
	        			   if (JavaNodesObject.get("Adapters").equals(true)) {JavaNodes_Adapters.add(subdir.getName());}	        			   
	        			   if (JavaNodesObject.get("CICS").equals(true)) {JavaNodes_CICS.add(subdir.getName());}
	        			   if (JavaNodesObject.get("CORBA").equals(true)) {JavaNodes_CORBA.add(subdir.getName());}
	        			   if (JavaNodesObject.get("Collection").equals(true)) {JavaNodes_Collection.add(subdir.getName());}
	        			   if (JavaNodesObject.get("Email").equals(true)) {JavaNodes_Email.add(subdir.getName());}
	        			   if (JavaNodesObject.get("File").equals(true)) {JavaNodes_File.add(subdir.getName());}
	        			   if (JavaNodesObject.get("IMS").equals(true)) {JavaNodes_IMS.add(subdir.getName());}
	        			   if (JavaNodesObject.get("JDBC").equals(true)) {JavaNodes_JDBC.add(subdir.getName());}
	        			   if (JavaNodesObject.get("JMS").equals(true)) {JavaNodes_JMS.add(subdir.getName());}
	        			   if (JavaNodesObject.get("JavaCompute").equals(true)) {JavaNodes_JavaCompute.add(subdir.getName());}
	        			   if (JavaNodesObject.get("Kafka").equals(true)) {JavaNodes_Kafka.add(subdir.getName());}
	        			   if (JavaNodesObject.get("MQTT").equals(true)) {JavaNodes_MQTT.add(subdir.getName());}
	        			   if (JavaNodesObject.get("Mapping").equals(true)) {JavaNodes_Mapping.add(subdir.getName());}
	        			   if (JavaNodesObject.get("ODM").equals(true)) {JavaNodes_ODM.add(subdir.getName());}
	        			   if (JavaNodesObject.get("TCPIP").equals(true)) {JavaNodes_TCPIP.add(subdir.getName());}
	        			   if (JavaNodesObject.get("WSRR").equals(true)) {JavaNodes_WSRR.add(subdir.getName());}
	        			   if (JavaNodesObject.get("XSLT").equals(true)) {JavaNodes_XSLT.add(subdir.getName());}
	        			   
	        			   // Record matches for JavaScriptNodes
	        			   Map<String, Object> JavaScriptNodesObject = (Map<String, Object>) obj.get("JavaScriptNodes");
	        			   if (JavaScriptNodesObject.get("LoopBack").equals(true)) {JavaScriptNodes_LoopBack.add(subdir.getName());}
	        			   if (JavaScriptNodesObject.get("Salesforce").equals(true)) {JavaScriptNodes_Salesforce.add(subdir.getName());}
	        			   
	        			   // Record matches for ResourceManagers
	        			   Map<String, Object> ResourceManagersObject = (Map<String, Object>) obj.get("ResourceManagers");
	        			   if (ResourceManagersObject.get("FTE").equals(true)) {ResourceManagers_FTE.add(subdir.getName());}
	        			   if (ResourceManagersObject.get("GlobalCache").equals(true)) {ResourceManagers_GlobalCache.add(subdir.getName());}

	        			   // Record matches for FlowSecurityProviders
	        			   Map<String, Object> FlowSecurityProvidersObject = (Map<String, Object>) obj.get("FlowSecurityProviders");
	        			   if (FlowSecurityProvidersObject.get("LDAP").equals(true)) {FlowSecurityProviders_LDAP.add(subdir.getName());}
	        			   if (FlowSecurityProvidersObject.get("TFIM").equals(true)) {FlowSecurityProviders_TFIM.add(subdir.getName());}
	        			   if (FlowSecurityProvidersObject.get("WS-Trust").equals(true)) {FlowSecurityProviders_WS_Trust.add(subdir.getName());}	        			   	        			   
	            		} catch (FileNotFoundException e) {
	            			// TODO Auto-generated catch block
	            			e.printStackTrace();
	            		} 
	            	}
	            }
	        }
	        System.out.println("\nOVERALL RESULTS OF ANALYZING OPTIMIZATIONS AS FOLLOWS ...");

	        System.out.print("\nCLR: " + CLR);
	        System.out.print("\nDeploy: " + Deploy);
	        System.out.print("\nJVM: " + JVM);
	        System.out.print("\nNodeJS: " + NodeJS);
	        System.out.print("\nNodes_Dotnet: " + Nodes_Dotnet);
			System.out.print("\nNodes_Aggregation: " + Nodes_Aggregation);
			System.out.print("\nNodes_Basic: " + Nodes_Basic);
			System.out.print("\nNodes_CallableFlow: " + Nodes_CallableFlow);
			System.out.print("\nNodes_Connector: " + Nodes_Connector);
			System.out.print("\nNodes_ESQL: " + Nodes_ESQL);
			System.out.print("\nNodes_Group: " + Nodes_Group);
			System.out.print("\nNodes_JMSTransform: " + Nodes_JMSTransform);
			System.out.print("\nNodes_MQ: " + Nodes_MQ);
			System.out.print("\nNodes_REST: " + Nodes_REST);
			System.out.print("\nNodes_SecurityPEP: " + Nodes_SecurityPEP);
			System.out.print("\nNodes_Timer: " + Nodes_Timer);
			System.out.print("\nJavaNodes_Adapters: " + JavaNodes_Adapters);
			System.out.print("\nJavaNodes_CICS: " + JavaNodes_CICS);
			System.out.print("\nJavaNodes_CORBA: " + JavaNodes_CORBA);
			System.out.print("\nJavaNodes_Collection: " + JavaNodes_Collection);
			System.out.print("\nJavaNodes_Email: " + JavaNodes_Email);
			System.out.print("\nJavaNodes_File: " + JavaNodes_File);
			System.out.print("\nJavaNodes_IMS: " + JavaNodes_IMS);
			System.out.print("\nJavaNodes_JDBC: " + JavaNodes_JDBC);
			System.out.print("\nJavaNodes_JMS: " + JavaNodes_JMS);
			System.out.print("\nJavaNodes_JavaCompute: " + JavaNodes_JavaCompute);
			System.out.print("\nJavaNodes_Kafka: " + JavaNodes_Kafka);
			System.out.print("\nJavaNodes_MQTT: " + JavaNodes_MQTT);
			System.out.print("\nJavaNodes_Mapping: " + JavaNodes_Mapping);
			System.out.print("\nJavaNodes_ODM: " + JavaNodes_ODM);
			System.out.print("\nJavaNodes_TCPIP: " + JavaNodes_TCPIP);
			System.out.print("\nJavaNodes_WSRR: " + JavaNodes_WSRR);
			System.out.print("\nJavaNodes_XSLT: " + JavaNodes_XSLT);	        
			System.out.print("\nJavaScriptNodes_LoopBack: " + JavaScriptNodes_LoopBack);
	        System.out.print("\nJavaScriptNodes_Salesforce: " + JavaScriptNodes_Salesforce);
	        System.out.print("\nResourceManagers_FTE: " + ResourceManagers_FTE);
	        System.out.print("\nResourceManagers_GlobalCache: " + ResourceManagers_GlobalCache);
	        System.out.print("\nFlowSecurityProviders_LDAP: " + FlowSecurityProviders_LDAP);    
	        System.out.print("\nFlowSecurityProviders_TFIM: " + FlowSecurityProviders_TFIM);    
	        System.out.print("\nFlowSecurityProviders_WS_Trust: " + FlowSecurityProviders_WS_Trust);
	        
	        System.out.println("\n\nALL COMPLETE SO EXIT!");
	   }
}
