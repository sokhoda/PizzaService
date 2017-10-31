package infrastructure.event.handling;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.core.ResolvableType;


public class DistributedEventMulticaster implements ApplicationEventMulticaster {
    private ApplicationEventMulticaster asyncEventMulticaster;
    private ApplicationEventMulticaster syncEventMulticaster;

    @Override
    public void addApplicationListener(ApplicationListener<?> listener) {
        if (listener.getClass().getAnnotation(AsyncListener.class) != null) {
            asyncEventMulticaster.addApplicationListener(listener);
        } else {
            syncEventMulticaster.addApplicationListener(listener);
        }
    }

    @Override
    public void addApplicationListenerBean(String listenerBeanName) {
    }

    @Override
    public void removeApplicationListener(ApplicationListener<?> listener) {
        syncEventMulticaster.removeApplicationListener(listener);
        asyncEventMulticaster.removeApplicationListener(listener);
    }

    @Override
    public void removeApplicationListenerBean(String listenerBeanName) {
    }

    @Override
    public void removeAllListeners() {
        syncEventMulticaster.removeAllListeners();;
        asyncEventMulticaster.removeAllListeners();;
    }

    @Override
    public void multicastEvent(ApplicationEvent event) {
        syncEventMulticaster.multicastEvent(event);
        asyncEventMulticaster.multicastEvent(event);
    }

    @Override
    public void multicastEvent(ApplicationEvent event, ResolvableType eventType) {
        syncEventMulticaster.multicastEvent(event, eventType);
        asyncEventMulticaster.multicastEvent(event, eventType);
    }

    public void setAsyncEventMulticaster(ApplicationEventMulticaster asyncEventMulticaster) {
        this.asyncEventMulticaster = asyncEventMulticaster;
    }

    public void setSyncEventMulticaster(ApplicationEventMulticaster syncEventMulticaster) {
        this.syncEventMulticaster = syncEventMulticaster;
    }
}