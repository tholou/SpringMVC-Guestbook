# SpringMVC-Guestbook

Create a Spring MVC based web application, a guestbook – users can leave comments and reply to other comments.

Requirements:

• Functional requirements:

FR1. The user can enter the following data: name, e-mail and comment

FR2. The fields „name“ and „comment“ are mandatory

FR3. If the user has entered an e-mail address, the application must check its validity (just a format check, not if the domain actually exists)

FR4. The user must be able to reply to other comments. When replying, the original comment is cited in the reply

• Non-functional requirements:

NFR1. The application doesn’t have to save the comments to a database, the comments have to persist only until the application is restarted

NFR2. The application must use the MVC (model-view-controller) pattern

NFR3. The application must be based on the Spring MVC framework

NFR4. The application must be built using a widely used build tool (i.e. Gradle or Maven)
