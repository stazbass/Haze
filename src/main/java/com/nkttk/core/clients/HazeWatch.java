package com.nkttk.core.clients;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.regions.Region;
import com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import com.amazonaws.services.cloudwatch.model.*;
import com.amazonaws.services.cloudwatch.waiters.AmazonCloudWatchWaiters;

/**
 *
 */
public class HazeWatch implements AmazonCloudWatch {

  @Override
  public void setEndpoint(String endpoint) {

  }

  @Override
  public void setRegion(Region region) {

  }

  @Override
  public DeleteAlarmsResult deleteAlarms(DeleteAlarmsRequest deleteAlarmsRequest) {
    return null;
  }

  @Override
  public DescribeAlarmHistoryResult describeAlarmHistory(DescribeAlarmHistoryRequest describeAlarmHistoryRequest) {
    return null;
  }

  @Override
  public DescribeAlarmHistoryResult describeAlarmHistory() {
    return null;
  }

  @Override
  public DescribeAlarmsResult describeAlarms(DescribeAlarmsRequest describeAlarmsRequest) {
    return null;
  }

  @Override
  public DescribeAlarmsResult describeAlarms() {
    return null;
  }

  @Override
  public DescribeAlarmsForMetricResult describeAlarmsForMetric(DescribeAlarmsForMetricRequest describeAlarmsForMetricRequest) {
    return null;
  }

  @Override
  public DisableAlarmActionsResult disableAlarmActions(DisableAlarmActionsRequest disableAlarmActionsRequest) {
    return null;
  }

  @Override
  public EnableAlarmActionsResult enableAlarmActions(EnableAlarmActionsRequest enableAlarmActionsRequest) {
    return null;
  }

  @Override
  public GetMetricStatisticsResult getMetricStatistics(GetMetricStatisticsRequest getMetricStatisticsRequest) {
    return null;
  }

  @Override
  public ListMetricsResult listMetrics(ListMetricsRequest listMetricsRequest) {
    return null;
  }

  @Override
  public ListMetricsResult listMetrics() {
    return null;
  }

  @Override
  public PutMetricAlarmResult putMetricAlarm(PutMetricAlarmRequest putMetricAlarmRequest) {
    return null;
  }

  @Override
  public PutMetricDataResult putMetricData(PutMetricDataRequest putMetricDataRequest) {
    return null;
  }

  @Override
  public SetAlarmStateResult setAlarmState(SetAlarmStateRequest setAlarmStateRequest) {
    return null;
  }

  @Override
  public void shutdown() {

  }

  @Override
  public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
    return null;
  }

  @Override
  public AmazonCloudWatchWaiters waiters() {
    return null;
  }
}
