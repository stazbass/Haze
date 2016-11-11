package com.nkttk.core.clients;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.regions.Region;
import com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import com.amazonaws.services.cloudwatch.model.*;

/**
 *
 */
public class HazeWatch implements AmazonCloudWatch {
  @Override
  public void setEndpoint(String s) throws IllegalArgumentException {

  }

  @Override
  public void setRegion(Region region) throws IllegalArgumentException {

  }

  @Override
  public void putMetricAlarm(PutMetricAlarmRequest putMetricAlarmRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public void putMetricData(PutMetricDataRequest putMetricDataRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public ListMetricsResult listMetrics(ListMetricsRequest listMetricsRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public GetMetricStatisticsResult getMetricStatistics(GetMetricStatisticsRequest getMetricStatisticsRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public void disableAlarmActions(DisableAlarmActionsRequest disableAlarmActionsRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public DescribeAlarmsResult describeAlarms(DescribeAlarmsRequest describeAlarmsRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public DescribeAlarmsForMetricResult describeAlarmsForMetric(DescribeAlarmsForMetricRequest describeAlarmsForMetricRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public DescribeAlarmHistoryResult describeAlarmHistory(DescribeAlarmHistoryRequest describeAlarmHistoryRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public void enableAlarmActions(EnableAlarmActionsRequest enableAlarmActionsRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public void deleteAlarms(DeleteAlarmsRequest deleteAlarmsRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public void setAlarmState(SetAlarmStateRequest setAlarmStateRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public ListMetricsResult listMetrics() throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public DescribeAlarmsResult describeAlarms() throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public DescribeAlarmHistoryResult describeAlarmHistory() throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public void shutdown() {

  }

  @Override
  public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest amazonWebServiceRequest) {
    return null;
  }
}
