FROM rabbitmq:3.9.12-management-alpine
RUN rabbitmq-plugins enable rabbitmq_management
RUN rabbitmqctl add_user admin pass
RUN rabbitmqctl set_user_tags admin administrator
RUN rabbitmqctl set_permissions -p / admin ".*" ".*" ".*"
