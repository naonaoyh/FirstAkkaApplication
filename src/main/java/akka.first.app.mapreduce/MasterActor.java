package akka.first.app.mapreduce;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.routing.RoundRobinRouter;

/**
 * Created with IntelliJ IDEA.
 * User: yuanhong
 * Date: 12-12-26
 * Time: 下午4:58
 */
public class MasterActor extends UntypedActor {
    ActorRef mapActor = getContext().actorOf(new Props(MapActor.class).withRouter(new RoundRobinRouter(5)), "map");
    ActorRef reduceActor = getContext().actorOf(new Props(ReduceActor.class).withRouter(new RoundRobinRouter(5)), "reduce");
    ActorRef aggregateActor = getContext().actorOf(new Props(AggregateActor.class).withRouter(new RoundRobinRouter(5)), "aggregate");

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof String) {
            mapActor.tell(message, getSelf());
        } else if (message instanceof MapData) {
            reduceActor.tell(message, getSelf());
        } else if (message instanceof ReduceData) {
            aggregateActor.tell(message, getSelf());
        } else if (message instanceof Result) {
            aggregateActor.forward(message, getContext());
        } else
            unhandled(message);

    }
}
