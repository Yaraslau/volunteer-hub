<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="main">
    <div class="text-section">Welcome to event:</div>
    <div class="text-section event-name">${event.name}</div>
    <div class="text-section event-owner">Owner: ${event.owner.name}</div>
    <c:set var="activitiesNumber" value="${event.activities.size()}" />
    <c:choose>
        <c:when test="${activitiesNumber > 0}">
            <div class="text-section activities-title">Event Activities (${activitiesNumber} opened):</div>
            <div class="table">
                <c:forEach items="${event.activities}" var="activity" varStatus="status">
                    <c:set var="availableNumber" value="${activity.demand - activity.volunteers.size()}" />
                    <div class="table-item ${status.index % 2 == 0 ? 'bg-color' : ''}">
                        <div class="activity-name">${activity.name}</div>
                        <div class="table-string">
                            <div class="table-column">Demand: ${activity.demand}</div>
                            <div class="table-column">Available: ${availableNumber > 0 ? availableNumber : 0}</div>
                            <div class="table-column">Paid: ${activity.salary > 0 ? activity.salary : "NO"}</div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:when>
        <c:otherwise>
            <div class="text-section">Currently this event doesn't have any opened activities.</div>
        </c:otherwise>
    </c:choose>

</div>
