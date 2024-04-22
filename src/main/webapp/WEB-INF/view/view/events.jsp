<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="main">
    <div class="text-section">Choose event to get more information about open activities for volunteers.</div>
    <div class="table">
        <c:forEach items="${events}" var="event" varStatus="status">
            <div class="table-item ${status.index % 2 == 0 ? 'bg-color' : ''}">
                <div><a href="/event/get/${event.id}" title="Click to get more information about ${event.name} event">${event.name}</a></div>
            </div>
        </c:forEach>
    </div>
</div>
