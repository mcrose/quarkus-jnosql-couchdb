# quarkus-jnosql-couchdb
Quarkus with JNoSQL integraton: CouchDB example


# Quarkus init with
mvn io.quarkus:quarkus-maven-plugin:0.28.0:create \
    -DprojectGroupId=py.com.icarusdb \
    -DprojectArtifactId=quarkus-jnosql-couchdb \
    -DclassName="py.com.icarusdb.quarkus.jnosql.couchdb.rest.GreetingResource" \
    -Dpath="/hello"

# JNoSQL / CouchDB
        <dependency>
            <groupId>org.jnosql.artemis</groupId>
            <artifactId>artemis-document</artifactId>
            <version>${jnosql.version}</version>
        </dependency>
        <dependency>
            <groupId>org.jnosql.diana</groupId>
            <artifactId>couchdb-driver</artifactId>
            <version>${jnosql.version}</version>
        </dependency>
 

# Stacktrace
C:\Users\rgamarra\git\quarkus-jnosql-couchdb>mvnw.cmd clean compile quarkus:dev
[INFO] Scanning for projects...
[INFO]
[INFO] ---------------< py.com.icarusdb:quarkus-jnosql-couchdb >---------------
[INFO] Building quarkus-jnosql-couchdb 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ quarkus-jnosql-couchdb ---
[INFO] Deleting C:\Users\rgamarra\git\quarkus-jnosql-couchdb\target
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ quarkus-jnosql-couchdb ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 3 resources
[INFO]
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ quarkus-jnosql-couchdb ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 9 source files to C:\Users\rgamarra\git\quarkus-jnosql-couchdb\target\classes
[INFO]
[INFO] --- quarkus-maven-plugin:0.28.1:dev (default-cli) @ quarkus-jnosql-couchdb ---
Listening for transport dt_socket at address: 5005
16:38:14,299 INFO  [io.qua.dep.QuarkusAugmentor] Beginning quarkus augmentation
16:38:14,564 INFO  [org.jbo.threads] JBoss Threads version 3.0.0.Final
16:38:14,975 ERROR [io.qua.dev.DevModeMain] Failed to start Quarkus: java.lang.RuntimeException: io.quarkus.builder.BuildException: Build failure: Build failed due to errors
        [error]: Build step io.quarkus.arc.deployment.ArcProcessor#validate threw an exception: javax.enterprise.inject.spi.DeploymentException: Found 2 deployment problems:
[1] Unsatisfied dependency for type org.jnosql.artemis.document.DocumentWorkflow and qualifiers [@Default]
        - java member: org.jnosql.artemis.document.DefaultDocumentTemplateProducer#workflow
        - declared on CLASS bean [types=[java.lang.Object, org.jnosql.artemis.document.DocumentTemplateProducer, org.jnosql.artemis.document.DefaultDocumentTemplateProducer], qualifiers=[@Default, @Any], target=org.jnosql.artemis.document.DefaultDocumentTemplateProducer]
[2] Unsatisfied dependency for type org.jnosql.artemis.reflection.ClassMappingExtension and qualifiers [@Default]
        - java member: org.jnosql.artemis.reflection.DefaultClassMappings#extension
        - declared on CLASS bean [types=[org.jnosql.artemis.reflection.DefaultClassMappings, org.jnosql.artemis.reflection.ClassMappings, java.lang.Object], qualifiers=[@Default, @Any], target=org.jnosql.artemis.reflection.DefaultClassMappings]
        at io.quarkus.arc.processor.BeanDeployment.processErrors(BeanDeployment.java:858)
        at io.quarkus.arc.processor.BeanDeployment.init(BeanDeployment.java:220)
        at io.quarkus.arc.processor.BeanProcessor.initialize(BeanProcessor.java:106)
        at io.quarkus.arc.deployment.ArcProcessor.validate(ArcProcessor.java:251)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:566)
        at io.quarkus.deployment.ExtensionLoader$1.execute(ExtensionLoader.java:941)
        at io.quarkus.builder.BuildContext.run(BuildContext.java:415)
        at org.jboss.threads.ContextClassLoaderSavingRunnable.run(ContextClassLoaderSavingRunnable.java:35)
        at org.jboss.threads.EnhancedQueueExecutor.safeRun(EnhancedQueueExecutor.java:2011)
        at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.doRunTask(EnhancedQueueExecutor.java:1535)
        at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1426)
        at java.base/java.lang.Thread.run(Thread.java:834)
        at org.jboss.threads.JBossThread.run(JBossThread.java:479)
        Suppressed: javax.enterprise.inject.UnsatisfiedResolutionException: Unsatisfied dependency for type org.jnosql.artemis.document.DocumentWorkflow and qualifiers [@Default]
        - java member: org.jnosql.artemis.document.DefaultDocumentTemplateProducer#workflow
        - declared on CLASS bean [types=[java.lang.Object, org.jnosql.artemis.document.DocumentTemplateProducer, org.jnosql.artemis.document.DefaultDocumentTemplateProducer], qualifiers=[@Default, @Any], target=org.jnosql.artemis.document.DefaultDocumentTemplateProducer]
                at io.quarkus.arc.processor.Beans.resolveInjectionPoint(Beans.java:472)
                at io.quarkus.arc.processor.BeanInfo.init(BeanInfo.java:404)
                at io.quarkus.arc.processor.BeanDeployment.init(BeanDeployment.java:212)
                ... 14 more
        Suppressed: javax.enterprise.inject.UnsatisfiedResolutionException: Unsatisfied dependency for type org.jnosql.artemis.reflection.ClassMappingExtension and qualifiers [@Default]
        - java member: org.jnosql.artemis.reflection.DefaultClassMappings#extension
        - declared on CLASS bean [types=[org.jnosql.artemis.reflection.DefaultClassMappings, org.jnosql.artemis.reflection.ClassMappings, java.lang.Object], qualifiers=[@Default, @Any], target=org.jnosql.artemis.reflection.DefaultClassMappings]
                at io.quarkus.arc.processor.Beans.resolveInjectionPoint(Beans.java:472)
                at io.quarkus.arc.processor.BeanInfo.init(BeanInfo.java:404)
                at io.quarkus.arc.processor.BeanDeployment.init(BeanDeployment.java:212)
                ... 14 more

        at io.quarkus.runner.RuntimeRunner.run(RuntimeRunner.java:157)
        at io.quarkus.dev.DevModeMain.doStart(DevModeMain.java:176)
        at io.quarkus.dev.DevModeMain.start(DevModeMain.java:94)
        at io.quarkus.dev.DevModeMain.main(DevModeMain.java:66)
Caused by: io.quarkus.builder.BuildException: Build failure: Build failed due to errors
        [error]: Build step io.quarkus.arc.deployment.ArcProcessor#validate threw an exception: javax.enterprise.inject.spi.DeploymentException: Found 2 deployment problems:
[1] Unsatisfied dependency for type org.jnosql.artemis.document.DocumentWorkflow and qualifiers [@Default]
        - java member: org.jnosql.artemis.document.DefaultDocumentTemplateProducer#workflow
        - declared on CLASS bean [types=[java.lang.Object, org.jnosql.artemis.document.DocumentTemplateProducer, org.jnosql.artemis.document.DefaultDocumentTemplateProducer], qualifiers=[@Default, @Any], target=org.jnosql.artemis.document.DefaultDocumentTemplateProducer]
[2] Unsatisfied dependency for type org.jnosql.artemis.reflection.ClassMappingExtension and qualifiers [@Default]
        - java member: org.jnosql.artemis.reflection.DefaultClassMappings#extension
        - declared on CLASS bean [types=[org.jnosql.artemis.reflection.DefaultClassMappings, org.jnosql.artemis.reflection.ClassMappings, java.lang.Object], qualifiers=[@Default, @Any], target=org.jnosql.artemis.reflection.DefaultClassMappings]
        at io.quarkus.arc.processor.BeanDeployment.processErrors(BeanDeployment.java:858)
        at io.quarkus.arc.processor.BeanDeployment.init(BeanDeployment.java:220)
        at io.quarkus.arc.processor.BeanProcessor.initialize(BeanProcessor.java:106)
        at io.quarkus.arc.deployment.ArcProcessor.validate(ArcProcessor.java:251)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:566)
        at io.quarkus.deployment.ExtensionLoader$1.execute(ExtensionLoader.java:941)
        at io.quarkus.builder.BuildContext.run(BuildContext.java:415)
        at org.jboss.threads.ContextClassLoaderSavingRunnable.run(ContextClassLoaderSavingRunnable.java:35)
        at org.jboss.threads.EnhancedQueueExecutor.safeRun(EnhancedQueueExecutor.java:2011)
        at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.doRunTask(EnhancedQueueExecutor.java:1535)
        at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1426)
        at java.base/java.lang.Thread.run(Thread.java:834)
        at org.jboss.threads.JBossThread.run(JBossThread.java:479)
        Suppressed: javax.enterprise.inject.UnsatisfiedResolutionException: Unsatisfied dependency for type org.jnosql.artemis.document.DocumentWorkflow and qualifiers [@Default]
        - java member: org.jnosql.artemis.document.DefaultDocumentTemplateProducer#workflow
        - declared on CLASS bean [types=[java.lang.Object, org.jnosql.artemis.document.DocumentTemplateProducer, org.jnosql.artemis.document.DefaultDocumentTemplateProducer], qualifiers=[@Default, @Any], target=org.jnosql.artemis.document.DefaultDocumentTemplateProducer]
                at io.quarkus.arc.processor.Beans.resolveInjectionPoint(Beans.java:472)
                at io.quarkus.arc.processor.BeanInfo.init(BeanInfo.java:404)
                at io.quarkus.arc.processor.BeanDeployment.init(BeanDeployment.java:212)
                ... 14 more
        Suppressed: javax.enterprise.inject.UnsatisfiedResolutionException: Unsatisfied dependency for type org.jnosql.artemis.reflection.ClassMappingExtension and qualifiers [@Default]
        - java member: org.jnosql.artemis.reflection.DefaultClassMappings#extension
        - declared on CLASS bean [types=[org.jnosql.artemis.reflection.DefaultClassMappings, org.jnosql.artemis.reflection.ClassMappings, java.lang.Object], qualifiers=[@Default, @Any], target=org.jnosql.artemis.reflection.DefaultClassMappings]
                at io.quarkus.arc.processor.Beans.resolveInjectionPoint(Beans.java:472)
                at io.quarkus.arc.processor.BeanInfo.init(BeanInfo.java:404)
                at io.quarkus.arc.processor.BeanDeployment.init(BeanDeployment.java:212)
                ... 14 more

        at io.quarkus.builder.Execution.run(Execution.java:108)
        at io.quarkus.builder.BuildExecutionBuilder.execute(BuildExecutionBuilder.java:121)
        at io.quarkus.deployment.QuarkusAugmentor.run(QuarkusAugmentor.java:130)
        at io.quarkus.runner.RuntimeRunner.run(RuntimeRunner.java:111)
        ... 3 more
Caused by: javax.enterprise.inject.spi.DeploymentException: Found 2 deployment problems:
[1] Unsatisfied dependency for type org.jnosql.artemis.document.DocumentWorkflow and qualifiers [@Default]
        - java member: org.jnosql.artemis.document.DefaultDocumentTemplateProducer#workflow
        - declared on CLASS bean [types=[java.lang.Object, org.jnosql.artemis.document.DocumentTemplateProducer, org.jnosql.artemis.document.DefaultDocumentTemplateProducer], qualifiers=[@Default, @Any], target=org.jnosql.artemis.document.DefaultDocumentTemplateProducer]
[2] Unsatisfied dependency for type org.jnosql.artemis.reflection.ClassMappingExtension and qualifiers [@Default]
        - java member: org.jnosql.artemis.reflection.DefaultClassMappings#extension
        - declared on CLASS bean [types=[org.jnosql.artemis.reflection.DefaultClassMappings, org.jnosql.artemis.reflection.ClassMappings, java.lang.Object], qualifiers=[@Default, @Any], target=org.jnosql.artemis.reflection.DefaultClassMappings]
        at io.quarkus.arc.processor.BeanDeployment.processErrors(BeanDeployment.java:858)
        at io.quarkus.arc.processor.BeanDeployment.init(BeanDeployment.java:220)
        at io.quarkus.arc.processor.BeanProcessor.initialize(BeanProcessor.java:106)
        at io.quarkus.arc.deployment.ArcProcessor.validate(ArcProcessor.java:251)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:566)
        at io.quarkus.deployment.ExtensionLoader$1.execute(ExtensionLoader.java:941)
        at io.quarkus.builder.BuildContext.run(BuildContext.java:415)
        at org.jboss.threads.ContextClassLoaderSavingRunnable.run(ContextClassLoaderSavingRunnable.java:35)
        at org.jboss.threads.EnhancedQueueExecutor.safeRun(EnhancedQueueExecutor.java:2011)
        at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.doRunTask(EnhancedQueueExecutor.java:1535)
        at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1426)
        at java.base/java.lang.Thread.run(Thread.java:834)
        at org.jboss.threads.JBossThread.run(JBossThread.java:479)
        Suppressed: javax.enterprise.inject.UnsatisfiedResolutionException: Unsatisfied dependency for type org.jnosql.artemis.document.DocumentWorkflow and qualifiers [@Default]
        - java member: org.jnosql.artemis.document.DefaultDocumentTemplateProducer#workflow
        - declared on CLASS bean [types=[java.lang.Object, org.jnosql.artemis.document.DocumentTemplateProducer, org.jnosql.artemis.document.DefaultDocumentTemplateProducer], qualifiers=[@Default, @Any], target=org.jnosql.artemis.document.DefaultDocumentTemplateProducer]
                at io.quarkus.arc.processor.Beans.resolveInjectionPoint(Beans.java:472)
                at io.quarkus.arc.processor.BeanInfo.init(BeanInfo.java:404)
                at io.quarkus.arc.processor.BeanDeployment.init(BeanDeployment.java:212)
                ... 14 more
        Suppressed: javax.enterprise.inject.UnsatisfiedResolutionException: Unsatisfied dependency for type org.jnosql.artemis.reflection.ClassMappingExtension and qualifiers [@Default]
        - java member: org.jnosql.artemis.reflection.DefaultClassMappings#extension
        - declared on CLASS bean [types=[org.jnosql.artemis.reflection.DefaultClassMappings, org.jnosql.artemis.reflection.ClassMappings, java.lang.Object], qualifiers=[@Default, @Any], target=org.jnosql.artemis.reflection.DefaultClassMappings]
                at io.quarkus.arc.processor.Beans.resolveInjectionPoint(Beans.java:472)
                at io.quarkus.arc.processor.BeanInfo.init(BeanInfo.java:404)
                at io.quarkus.arc.processor.BeanDeployment.init(BeanDeployment.java:212)
                ... 14 more

16:38:14,979 INFO  [io.qua.dev.DevModeMain] Attempting to start hot replacement endpoint to recover from previous Quarkus startup failure

 